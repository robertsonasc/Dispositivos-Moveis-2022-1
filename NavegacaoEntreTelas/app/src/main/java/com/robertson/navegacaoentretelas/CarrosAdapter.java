package com.robertson.navegacaoentretelas;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarrosAdapter extends RecyclerView.Adapter<CarrosAdapter.CarroViewholder>{

    private final ArrayList<Carro> carros;
    private static final String TAG = "linhaCarrosAdapter";

    public CarrosAdapter(ArrayList<Carro> arrayCarros) {
        this.carros = arrayCarros;
    }

    @NonNull
    @Override
    public CarroViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.carro_item, parent, false);
        return new CarroViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarroViewholder holder, int position) {
        Carro carro = carros.get(position);
        holder.bind(carro);
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    class CarroViewholder extends RecyclerView.ViewHolder{
        TextView nome, cilindrada, placa, qtdPessoas, id;
        public CarroViewholder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textViewNomeCarro);
            cilindrada = itemView.findViewById(R.id.textViewCilindradaCarro);
            placa = itemView.findViewById(R.id.textViewPlacaCarro);
            qtdPessoas = itemView.findViewById(R.id.textViewQtdPessoasCarro);
            id = itemView.findViewById(R.id.textViewConteudoID);
        }
        public void bind(Carro carro){
            nome.setText(carro.getNome());
            cilindrada.setText(String.valueOf(carro.getCilindrada()));
            placa.setText(carro.getPlaca());
            qtdPessoas.setText(String.valueOf(carro.getQtdPessoas()));
            id.setText(carro.getId());
        }
    }
}
