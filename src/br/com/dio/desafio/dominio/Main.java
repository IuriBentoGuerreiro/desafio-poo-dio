package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando cursos e mentoria
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descrição curso JavaScript");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria Java");
        mentoria.setData(LocalDate.now());

        // Criando bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Criando devs
        Dev dev = new Dev();
        System.out.print("Digite o nome do Dev: ");
        dev.setNome(scanner.nextLine());
        dev.inscreverBootcamp(bootcamp);

        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ver conteúdos inscritos");
            System.out.println("2. Progredir");
            System.out.println("3. Ver conteúdos concluídos");
            System.out.println("4. Ver XP total");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Conteúdos Inscritos: " + dev.getConteudosInscritos());
                    break;
                case 2:
                    dev.progredir();
                    break;
                case 3:
                    System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos());
                    break;
                case 4:
                    System.out.println("XP Total: " + dev.calcularTotalXp());
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
