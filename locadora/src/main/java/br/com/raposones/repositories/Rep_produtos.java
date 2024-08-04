package br.com.raposones.repositories;

import java.util.HashMap;
import java.util.Scanner;

import br.com.raposones.models.BluRay;
import br.com.raposones.models.CD;
import br.com.raposones.models.DVD;
import br.com.raposones.models.LP;
import br.com.raposones.models.Produto;
import br.com.raposones.models.VHS;

public class Rep_produtos {
    // <chave - codigo  || valor - objeto>  
    HashMap<String, Produto> repos_produtos = new HashMap<String, Produto>();

    static Scanner scan = new Scanner(System.in);

    public int lenghtProducts(){
        return repos_produtos.size();
    }

    public void addProduto(Produto produto){
        repos_produtos.put(produto.getCodigo(), produto);
    }

    public void remProduto(String codigo){
        repos_produtos.remove(codigo);
    }

    public Produto getProduto(String codigo){
        return repos_produtos.get(codigo);
    }

    public boolean checkExistance_Produto(String codigo){
        boolean existe = false;

        for(String i : repos_produtos.keySet()){
            Produto aux = repos_produtos.get(i);

            if(codigo.equals(aux.getCodigo())){
                existe = true;
                break;
            }
        }
        return existe;
    }

 
    public void listProdutos(){
        for(String i : repos_produtos.keySet()){
            Produto aux = repos_produtos.get(i);

            System.out.println("\n================");

            if (aux instanceof DVD){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: FILME - DVD");
                System.out.println("Genero: " + aux.getGenero());
            }

            else if(aux instanceof BluRay){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: FILME - Blu-Ray");
                System.out.println("Genero: " + aux.getGenero());
            }

            else if(aux instanceof VHS){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: FILME - VHS");
                System.out.println("Genero: " + aux.getGenero());
            }

            else if(aux instanceof CD){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: MÚSICA - CD");
                System.out.println("Genero: " + aux.getGenero());
            }

            else if(aux instanceof LP){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: MÚSICA - LP");
                System.out.println("Genero: " + aux.getGenero());
            }

            System.out.println("================\n");
        }
    }

    public void showProduto(String cod){
        for(String i : repos_produtos.keySet()){
            Produto aux = repos_produtos.get(i);

            if (aux.getCodigo().equals(cod) && aux instanceof DVD){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: FILME - DVD");
                System.out.println("Genero: " + aux.getGenero());
                break;
            }

            else if(aux.getCodigo().equals(cod) && aux instanceof BluRay){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: FILME - Blu-Ray");
                System.out.println("Genero: " + aux.getGenero());
                break;
            }

            else if(aux.getCodigo().equals(cod) && aux instanceof VHS){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: FILME - VHS");
                System.out.println("Genero: " + aux.getGenero());
                break;
            }

            else if(aux.getCodigo().equals(cod) && aux instanceof CD){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: MÚSICA - CD");
                System.out.println("Genero: " + aux.getGenero());
                break;
            }

            else if(aux.getCodigo().equals(cod) && aux instanceof LP){
                System.out.println("Titulo: " + aux.getTitulo());
                System.out.println("Tipo: MÚSICA - LP");
                System.out.println("Genero: " + aux.getGenero());
                break;
            }
        }
    }

    public double calcPreco(Produto produto){ //preço base de locação
        double preco = 0;
        if (produto instanceof DVD){
            preco = 15;
        }

        else if(produto instanceof BluRay){
            preco = 25;
         }

        else if(produto instanceof VHS){
           VHS vhs = (VHS) produto;

            if(vhs.isCores()){
                 preco = 15;
            }

            else{
                preco = 10;
            }
        }

        else if(produto instanceof CD){
            CD cd = (CD) produto;

            if(cd.isDuplo()){
                preco = 20;
            }

            else{
                preco = 15;
            }
        }

        else if(produto instanceof LP){
            LP lp = (LP) produto;

            if(lp.isRaro()){
                preco = 100;
            }

            else{
                preco = 30;
            }
        }
        return preco;
    }

    public void checkIfModificado(Produto produto){

        if (produto instanceof DVD){
            DVD dvd = (DVD) produto;

            System.out.println("O DVD está arranhado? \n[s]im / [n]ao");
            String arg = scan.nextLine();

            if(arg.equals("s")){
                dvd.setArranhado(true);
                remProduto(produto.getCodigo());;
                addProduto(dvd);
            }
        }

        else if(produto instanceof CD){
            CD cd = (CD) produto;

            System.out.println("O CD está arranhado? \n[s]im / [n]ao");
            String arg = scan.nextLine();

            if(arg.equals("s")){
                cd.setArranhado(true);
                remProduto(produto.getCodigo());;
                addProduto(cd);
            }
        }
    } 
    

    public double checkModificador(Produto produto){
        double modificador = 0;

        if (produto instanceof DVD){
            DVD dvd = (DVD) produto;

            if(dvd.isArranhado()){
                System.out.println("+ ARRANHADO: +50%");
                modificador = 0.50;
            }
        }

        else if(produto instanceof CD){
            CD cd = (CD) produto;

            if(cd.isArranhado()){
                System.out.println(" + ARRANHADO: +50%");
                modificador = 0.50;
            }
        }

        return modificador;
    }  
}
