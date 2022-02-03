import java.io.IOException;
import java.util.Scanner;

public class AppPilotos {
    public static <vetorPilotos> void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        int MAX_ELEMENTOS_NOVO = MAX_ELEMENTOS;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Pessoa[] arrayTemp = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        
        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                //Cadastre seu piloto aqui
                System.out.println("Informe o nome do Piloto: ");
                //lendo um nome
                String nome = in.nextLine ();
                
                // ler um CPF
                System.out.println("Informe o CPF do Piloto: ");
                String cpf = in.nextLine ();
                
                //Cadastro completo pessoa
                Pessoa p1 = new Pessoa (nome,cpf);
                pilotos [qtdCadastrados] = p1;
                qtdCadastrados++;
                
                System.out.println("\nPiloto cadastrado com sucesso.");
                
                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                voltarMenu(in);
                continue;
                }

                // Exiba os pilotos aqui
                for (int i = 0; i < qtdCadastrados; i++) {
                    System.out.println("");
                    System.out.println(pilotos[i].getNome());
                    System.out.println(pilotos[i].getCPF());
                }
                voltarMenu(in);
            } else if (opcao == 3) {
                boolean validar = false;
                int achar = 0;

                System.out.println("Qual o CPF que deseja buscar?\n");
                String cpf = in.nextLine();
                
                //leitura do vetor
                for(int i = 0; i < qtdCadastrados; i++)
                {
                    if(pilotos[i].getCPF().equals(cpf))
                    {
                        validar = true;
                        achar = i;
                        i = qtdCadastrados;
                    }
                }
                if(validar)
                {
                    System.out.println("\nPiloto: " + pilotos[achar].getNome());
                }else
                {
                    System.out.println("CPF não informado/inválido");
                }
            
                
            } else if (opcao == 4) {
                System.out.println("Digite o novo tamanho do armazenamento");
                int valorDigitado = in.nextInt();

                if (valorDigitado > MAX_ELEMENTOS_NOVO) {

                    MAX_ELEMENTOS_NOVO = valorDigitado;

                    arrayTemp = new Pessoa[MAX_ELEMENTOS_NOVO];
                    for (int i = 0; i < pilotos.length; i++) {
                        arrayTemp[i] = pilotos[i];
                    }

                    pilotos = new Pessoa[MAX_ELEMENTOS_NOVO];

                    for (int i = 0; i < arrayTemp.length; i++) {
                        pilotos[i] = arrayTemp[i];

                        System.out.println("Novo tamanho definido");

                    }
                    
                } else {
                    System.out.println("O tamanho informado é menor que o tamanho atual");
                } 
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}