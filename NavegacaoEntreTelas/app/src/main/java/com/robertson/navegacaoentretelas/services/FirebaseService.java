package com.robertson.navegacaoentretelas.services;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.robertson.navegacaoentretelas.Carro;

import java.util.ArrayList;

public class FirebaseService {
    private static final FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static void getCarros(SetCarros setCarros, Context context){
        db.collection("Carros")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            ArrayList<Carro> carroArrayList = new ArrayList<>();
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                Carro c = documentSnapshot.toObject(Carro.class);
                                carroArrayList.add(c);
                            }
                            setCarros.arrayCarros(carroArrayList);
                        }else{
                            Toast.makeText(context,
                                    "Erro de conexão com o servidor",
                                    Toast.LENGTH_LONG)
                                    .show()
                            ;
                        }
                    }
                })
        ;
    }

    public static void addCarro(Carro carro){
        db.collection("Carros")
                .document(carro.getId())
                .set(carro);
    }

    public static void editarCarro(Carro carro){
        db.collection("Carros")
                .document(carro.getId())
                .update(
                        "nome", carro.getNome(),
                        "cilindrada", carro.getCilindrada(),
                        "placa", carro.getPlaca(),
                        "qtdPessoas", carro.getQtdPessoas(),
                        "id", carro.getId()
                );
    }

    public static void deleteCarro(Carro c){
        db.collection("Carros")
                .document(c.getId())
                .delete();
    }

    public interface SetCarros {
        void arrayCarros(ArrayList<Carro> carros);
    }

}
