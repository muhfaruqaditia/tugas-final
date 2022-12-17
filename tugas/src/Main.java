package org.example;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int pilihan;
        String namaFile = "hasil.txt";
        File file = new File(namaFile);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file,true)), true);
        do {
            System.out.println("\nPilih bangun datar yang ingin dihitung luasnya");
            System.out.println("1. Persegi");
            System.out.println("2. Persegi Panjang");
            System.out.println("3. Segitiga");
            System.out.println("4. Lingkaran");
            System.out.println("5. Keluar");
            System.out.println("6. Tampilkan Isi Dari File Output");
            System.out.println("7. Bersihkan Isi Dari File Output");
            System.out.print("Pilihan : ");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    Persegi persegi = new Persegi();
                    persegi.hitungLuas();
                    pw.println(persegi.toString());
                    break;
                case 2:
                    PersegiPanjang persegiPanjang = new PersegiPanjang();
                    persegiPanjang.hitungLuas();
                    pw.println(persegiPanjang.toString());
                    break;
                case 3:
                    Segitiga segitiga = new Segitiga();
                    segitiga.hitungLuas();
                    pw.println(segitiga.toString());
                    break;
                case 4:
                    Lingkaran lingkaran = new Lingkaran();
                    lingkaran.hitungLuas();
                    pw.println(lingkaran.toString());
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini");
                    break;
                case 6:
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String strCurrentLine;
                    while ((strCurrentLine = br.readLine()) != null)
                        System.out.println(strCurrentLine);
                    break;
                case 7:
                    PrintWriter hapusfile = new PrintWriter(new BufferedWriter(new FileWriter(file,false)), true);
                    System.out.println("!!!Isi File HASIL sudah di bersihkan!!!");
                    hapusfile.close();
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        } while (pilihan != 5);
        pw.close();

    }
}

abstract class BangunDatar {
    abstract void hitungLuas();
}

class Persegi extends BangunDatar {
    private double sisi;
    private double luas;

    public Persegi() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan sisi persegi : ");
        sisi = input.nextDouble();
    }

    @Override
    void hitungLuas() {
        luas = sisi * sisi;
    }

    @Override
    public String toString() {
        System.out.println("Luas persegi dengan sisi " + sisi + " adalah " + luas);
        return "Luas persegi dengan sisi " + sisi + " adalah " + luas;
    }
}

class PersegiPanjang extends BangunDatar {
    private double panjang;
    private double lebar;
    private double luas;

    public PersegiPanjang() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan panjang persegi panjang : ");
        panjang = input.nextDouble();
        System.out.print("Masukkan lebar persegi panjang : ");
        lebar = input.nextDouble();
    }

    @Override
    void hitungLuas() {
        luas = panjang * lebar;
    }

    @Override
    public String toString() {
        System.out.println("Luas persegi panjang dengan panjang " + panjang + " dan lebar " + lebar + " adalah " + luas);
        return "Luas persegi panjang dengan panjang " + panjang + " dan lebar " + lebar + " adalah " + luas;
    }
}

class Segitiga extends BangunDatar {
    private double alas;
    private double tinggi;
    private double luas;

    public Segitiga() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan alas segitiga : ");
        alas = input.nextDouble();
        System.out.print("Masukkan tinggi segitiga : ");
        tinggi = input.nextDouble();
    }

    @Override
    void hitungLuas() {
        luas = alas * tinggi / 2;
    }

    @Override
    public String toString() {
        System.out.println("Luas segitiga dengan alas" + alas + " dan tinggi " + tinggi + " adalah " + luas);
        return "Luas segitiga dengan alas " + alas + " dan tinggi " + tinggi + " adalah " + luas;
    }
}

class Lingkaran extends BangunDatar {
    private double jariJari;
    private double luas;

    public Lingkaran() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jari-jari lingkaran : ");
        jariJari = input.nextDouble();
    }

    @Override
    void hitungLuas() {
        luas = Math.PI * jariJari * jariJari;
    }

    @Override
    public String toString() {
        System.out.println("Luas lingkaran dengan jari-jari " + jariJari + " adalah " + luas);
        return "Luas lingkaran dengan jari-jari " + jariJari + " adalah " + luas;
    }
}

