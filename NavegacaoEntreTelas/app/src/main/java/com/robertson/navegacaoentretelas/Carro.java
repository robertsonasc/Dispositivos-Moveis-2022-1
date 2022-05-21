package com.robertson.navegacaoentretelas;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Carro implements Parcelable {
    String placa = "";
    String nome = "";
    String cilindrada = "";
    String qtdPessoas = "";
    String id = "";

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(String qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.placa);
        dest.writeString(this.nome);
        dest.writeString(this.cilindrada);
        dest.writeString(this.qtdPessoas);
        dest.writeString(this.id);
    }

    public void readFromParcel(Parcel source) {
        this.placa = source.readString();
        this.nome = source.readString();
        this.cilindrada = source.readString();
        this.qtdPessoas = source.readString();
        this.id = source.readString();
    }

    protected Carro(Parcel in) {
        this.placa = in.readString();
        this.nome = in.readString();
        this.cilindrada = in.readString();
        this.qtdPessoas = in.readString();
        this.id = in.readString();
    }
    public Carro(){};

    public static final Creator<Carro> CREATOR = new Creator<Carro>() {
        @Override
        public Carro createFromParcel(Parcel source) {
            return new Carro(source);
        }

        @Override
        public Carro[] newArray(int size) {
            return new Carro[size];
        }
    };
}
