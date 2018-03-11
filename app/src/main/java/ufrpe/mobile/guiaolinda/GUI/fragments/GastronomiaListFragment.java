package ufrpe.mobile.guiaolinda.GUI.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.GUI.activities.GastronomiaActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.InicioActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.MapsActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.SobreActivity;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Local;

public class GastronomiaListFragment extends Fragment {

    public final String AGREMIACAO_ID = "AGREMIACAO_ID";
    private RecyclerView mAgremiacaoRecyclerView;
    private AgremiacaoAdapter mAdapter;
    private LocalLab localLab;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef;

    private String tipo;

    public GastronomiaListFragment(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gastronomia_list, container, false);

        TextView v = view.findViewById(R.id.gastronomia_gastronomia);
        v.setText(tipo);

        mAgremiacaoRecyclerView = view.findViewById(R.id.gastronomia_recycler_view);
        mAgremiacaoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        FloatingActionButton buttonTopo = view.findViewById(R.id.botaoEventoTopo);
        buttonTopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager lManager = (LinearLayoutManager) mAgremiacaoRecyclerView.getLayoutManager();
                lManager.scrollToPositionWithOffset(0, 0);
            }
        });

        if (readFromFile().isEmpty() || readFromFile().equals("")) {
            gerarAgremiacoes();
        } else {
            int id = 0;
            String mopa = readFromFile();
            String[] aux = String.valueOf(mopa).split("/n");
            if (localLab.getLocals(tipo).size() == 0) {
                for (String anAux : aux) {
                    if (anAux.contains("/%")) {
                        anAux = anAux.replace("/%", "\n");
                    }
                    String[] aux2 = anAux.split("#");
                    if (aux2.length >= 6) {
                        localLab.createLocal(tipo, id++, aux2[0], aux2[1], aux2[2], aux2[3], aux2[4],
                                aux2[5], aux2[6], Double.parseDouble(aux2[7]), Double.parseDouble(aux2[8]));
                    }
                }
            }
        }
        updateUI();
        return view;
    }

    private void gerarAgremiacoes() {
        final ProgressDialog dialog = ProgressDialog.show(getContext(), "",
                "Loading...", true);
        dialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                geraAgremiacoes();
                updateUI();
                dialog.dismiss();
            }
        }, 5000);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_eventos, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.home:
                intent = new Intent(getActivity(), InicioActivity.class);
                startActivity(intent);
                return true;

            case R.id.mapa:
                intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
                return true;

            case R.id.sobre:
                intent = new Intent(getActivity(), SobreActivity.class);
                startActivity(intent);
                return true;

            case R.id.atualizar:
                gerarAgremiacoes();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.localLab = LocalLab.get();

        setHasOptionsMenu(true);
    }

    public void geraAgremiacoes() {
        myRef = database.getReference(tipo);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                localLab.flushLocals(tipo);
                int id = 0;
                int mp = 0;
                ArrayList<String> aux;
                StringBuilder str = new StringBuilder();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    aux = new ArrayList<>();
                    for (int i = 0; i < ds.getChildrenCount(); i++) {
                        String data = ds.child(Integer.toString(i)).getValue().toString();
                        aux.add(data);
                        str.append(data.replaceAll("\n", "/%")).append('#');
                    }
                    str.append("*/n");
                    if (aux.size() >= 6) {
                        localLab.createLocal(tipo, id++, aux.get(0), aux.get(1), aux.get(2), aux.get(3), aux.get(4),
                                aux.get(5), aux.get(6), Double.parseDouble(aux.get(7)), Double.parseDouble(aux.get(8)));
                        if (!aux.get(1).equals("-")) {
                            Picasso.with(getContext()).load(aux.get(0)).into(picassoImageTarget(getContext(), "imageDir", aux.get(1) + ".jpeg"));
                        }
                    }
                    if (mp == 0) {
                        mp++;
                    }
                    aux.clear();
                }
                mAdapter.notifyDataSetChanged();
                writeToFile(str.toString(), getContext());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput((tipo + ".txt"), Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile() {

        String ret = "";
        try {
            InputStream inputStream = getContext().openFileInput((tipo + ".txt"));

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString;
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    private void updateUI() {
        List<Local> agremiacoes;
        agremiacoes = localLab.getLocals(tipo);
        if (mAdapter == null) {
            mAdapter = new AgremiacaoAdapter(agremiacoes);
            mAgremiacaoRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private Target picassoImageTarget(Context context, final String imageDir, final String imageName) {
        Log.d("picassoImageTarget", " picassoImageTarget");
        ContextWrapper cw = new ContextWrapper(context);
        final File directory = cw.getDir(imageDir, Context.MODE_PRIVATE); // path to /data/data/yourapp/app_imageDir
        return new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final File myImageFile = new File(directory, imageName); // Create image file
                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(myImageFile);
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.i("image", "image saved to >>>" + myImageFile.getAbsolutePath());

                    }
                }).start();
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                if (placeHolderDrawable != null) {
                }
            }
        };
    }

    private class AgremiacaoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNomeTextView;
        private TextView mFoneTextView;
        private ImageView mLocalImageView;

        private Local mLocal;

        AgremiacaoHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_gastro, parent, false));
            itemView.setOnClickListener(this);

            mNomeTextView = itemView.findViewById(R.id.nome_lugar);
            mFoneTextView = itemView.findViewById(R.id.fone_lugar);
            mLocalImageView = itemView.findViewById(R.id.imagem_lugar);
        }

        void bind(Local local) {
            mLocal = local;
            mNomeTextView.setText(mLocal.get_nome_local().toLowerCase());
            mFoneTextView.setText(mLocal.getTelefone());
            if (mLocal.getImage().equals("-"))
                Picasso.with(getContext()).load(R.drawable.semfoto).into(mLocalImageView);
            else {
                ContextWrapper cw = new ContextWrapper(getContext());
                File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
                File myImageFile = new File(directory, mLocal.get_nome_local() + ".jpeg");
                Picasso.with(getContext()).load(myImageFile).into(mLocalImageView);
                if (mLocalImageView.getDrawable() == null) {
                    Picasso.with(getContext()).load(mLocal.getImage()).into(mLocalImageView);
                    if (mLocalImageView.getDrawable() == null) {
                        Picasso.with(getContext()).load(R.drawable.semfoto).into(mLocalImageView);
                    }
                }
            }
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), GastronomiaActivity.class);
            intent.putExtra(AGREMIACAO_ID, mLocal.getid());
            intent.putExtra("TIPO_LOCAL", tipo);
            startActivity(intent);
        }
    }

    private class AgremiacaoAdapter extends RecyclerView.Adapter<AgremiacaoHolder> {
        private List<Local> mAgremiacoes;

        AgremiacaoAdapter(List<Local> agremiacao) {
            mAgremiacoes = agremiacao;
        }

        @Override
        public AgremiacaoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new AgremiacaoHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(AgremiacaoHolder holder, int position) {
            Local agremiacao = mAgremiacoes.get(position);
            holder.bind(agremiacao);
        }

        @Override
        public int getItemCount() {
            return mAgremiacoes.size();
        }
    }
}