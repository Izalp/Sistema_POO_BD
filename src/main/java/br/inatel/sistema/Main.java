package br.inatel.sistema;

import br.inatel.sistema.usuarios.Aluno;
import br.inatel.sistema.usuarios.Professor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AlunoBD alunoBD = new AlunoBD();
        ProfessorBD professorBD = new ProfessorBD();

        Scanner sc = new Scanner(System.in);
        int entrada;

        boolean flag = true;

        while (flag) {

            System.out.println("\nBEM VINDO AO SISTEMA:\n");
            System.out.println("1 - Aluno");
            System.out.println("2 - Professor");
            System.out.println("3 - Sair");
            System.out.println("\nEntre com a sua opção:");

            entrada = sc.nextInt();
            sc.nextLine();

            switch (entrada) {
                case 1 -> { //--------------------------------USUARIO ALUNO--------------------------------------
                    System.out.println("\nBEM VINDO AO MENU:\n");
                    System.out.println("1 - Cadastramento de alunos");
                    System.out.println("2 - Busca de dados de alunos cadastrados");
                    System.out.println("3 - Atualização de dados dos alunos:");
                    System.out.println("4 - Cancelamento de matrícula");
                    System.out.println("5 - Sair");
                    System.out.println("\nEntre com a sua opção: ");

                    int opcao = sc.nextInt();
                    sc.nextLine();

                    if (opcao == 1) { //-------------------------CADASTRANDO ALUNO-------------------------------
                        System.out.println("\nInsira o nome da Escola de Origem do aluno:");
                        String escolaOrigem;
                        escolaOrigem = sc.nextLine();

                        System.out.println("\nInsira o nome completo do aluno:");
                        String nome;
                        nome = sc.nextLine();

                        System.out.println("\nInsira o cpf completo do aluno:");
                        String cpf;
                        cpf = sc.nextLine();

                        System.out.println("\nInsira o rg completo do aluno:");
                        String rg;
                        rg = sc.nextLine();

                        System.out.println("\nInsira a data de Nascimento do aluno:");
                        String dataNasc;
                        dataNasc = sc.nextLine();

                        System.out.println("\nInsira a Naturalidade do aluno:");
                        String naturalidade;
                        naturalidade = sc.nextLine();

                        System.out.println("\nInsira o sexo do aluno:");
                        String sexo;
                        sexo = sc.nextLine();

                        // Tem criança que não tem pai:
                        System.out.println("\nInsira o nome completo da filiação 1 (mãe): ");
                        String nomeFiliacao1;
                        nomeFiliacao1 = sc.nextLine();

                        System.out.println("\nInsira o nome completo da filiação 2(pai): ");
                        String nomeFiliacao2;
                        nomeFiliacao2 = sc.nextLine();

                        if (nomeFiliacao2 == null) { //CASO O ALUNO NÃO POSSUA FILIAÇÃO 2(PAI)
                            break;
                        }

                        System.out.println("\nInsira o endereço completo do aluno:");
                        String endereco;
                        endereco = sc.nextLine();

                        System.out.println("\nInsira o telefone para contato do aluno:");
                        String contato;
                        contato = sc.nextLine();

                        Aluno aluno = new Aluno(escolaOrigem, nome, cpf, rg, dataNasc,naturalidade,
                                sexo, nomeFiliacao1, nomeFiliacao2, endereco, contato);

                        alunoBD.insertAluno(aluno); // CADASTRANDO ALUNO

                    } else if (opcao == 2) { //----------------BUSCANDO DADOS DE ALUNO CADASTRADO---------------
                        //Mostrando 1 usuario (Ver dps como inserir mais de 1):
                        alunoBD.researchAluno();

                    } else if (opcao == 3) {//--------------ATUALIZANDO ENDEREÇO OU CONTATO DO ALUNO------------
                        System.out.println("\nMENU de atualização:\n");
                        System.out.println("1 - Atualizar endereço");
                        System.out.println("2 - Atualizar contato");
                        System.out.println("3 - Sair do menu de atualização");
                        System.out.println("\nEntre com a sua opção:");

                        int atualizo = sc.nextInt();
                        int matriculaAt;

                        if(atualizo == 1) { //-----------------------ATUALIZANDO ENDEREÇO------------------------
                            matriculaAt = sc.nextInt();
                            sc.nextLine();
                            String enderecoAt = sc.nextLine();

                            alunoBD.updateAlunoEnd(matriculaAt, enderecoAt);
                        }
                        else if(atualizo == 2){ //---------------------ATUALIZANDO CONTATO-----------------------
                            matriculaAt = sc.nextInt();
                            sc.nextLine();
                            String contatoAt = sc.nextLine();

                            alunoBD.updateAlunoCont(matriculaAt, contatoAt);
                        }

                    } else if (opcao == 4) {//-----------------EXCLUINDO MATRÍCULA DO ALUNO----------------------
                        System.out.println("Digite o número de matrícula do Aluno a ser deletado:");
                        int id = sc.nextInt();
                        alunoBD.deleteAluno(id);
                    }
                }
                case 2 -> { //-----------------------------USUARIO PROFESSOR-------------------------------------
                    System.out.println("\nBEM VINDO AO MENU:\n");
                    System.out.println("1 - Cadastramento de Professores");
                    System.out.println("2 - Busca de dados de Professores");
                    System.out.println("3 - Atualização de dados Professores");
                    System.out.println("4 - Deletar dados de Professores");
                    System.out.println("5 - Sair");
                    System.out.println("\nEntre com a sua opção: ");

                    int opcao1 = sc.nextInt();
                    sc.nextLine();

                    if (opcao1 == 1) {
                        System.out.println("\nInsira seu nome completo:");
                        String pnome;
                        pnome = sc.nextLine();

                        System.out.println("\nInsira seu cpf:");
                        String pcpf;
                        pcpf = sc.nextLine();

                        System.out.println("\nInsira seu rg:");
                        String prg;
                        prg = sc.nextLine();

                        System.out.println("\nInsira sua data de Nascimento:");
                        String pdataNasc;
                        pdataNasc = sc.nextLine();

                        System.out.println("\nInsira sua naturalidade:");
                        String pnaturalidade;
                        pnaturalidade = sc.nextLine();

                        System.out.println("\nInsira seu sexo:");
                        String psexo;
                        psexo = sc.nextLine();

                        // Pode ter mais de 2 cargos:
                        System.out.println("\nInsira seu cargo: ");
                        String cargo;
                        cargo = sc.nextLine();

                        // Pode ter mais de uma disciplina dada:
                        System.out.println("\nInsira a disciplina dada: ");
                        String disciplina;
                        disciplina = sc.nextLine();

                        System.out.println("\nInsira seu endereço completo:");
                        String pendereco;
                        pendereco = sc.nextLine();

                        // Pode ser mais que 1 (ver depois):
                        System.out.println("\nInsira seu telefone para contato:");
                        String pcontato;
                        pcontato = sc.nextLine();

                        Professor professor = new Professor(pnome, pcpf, prg, pdataNasc, pnaturalidade, psexo,
                                cargo, disciplina, pendereco, pcontato);

                        professorBD.insertProfessor(professor);

                    } else if (opcao1 == 2) {//-------------BUSCANDO DADOS DE PROFESSOR CADASTRADO---------------
                        professorBD.researchProfessor();

                    } else if (opcao1 == 3) {//----------ATUALIZANDO ENDEREÇO OU CONTATO DO PROFESSOR------------
                        System.out.println("\nMENU de atualização:\n");
                        System.out.println("1 - Atualizar endereço");
                        System.out.println("2 - Atualizar contato");
                        System.out.println("3 - Sair do menu de atualização");
                        System.out.println("\nEntre com a sua opção:");

                        int atualizo = sc.nextInt();
                        int matriculaAt;

                        if(atualizo == 1) { //------------------------ATUALIZANDO ENDEREÇO-----------------------
                            matriculaAt = sc.nextInt();
                            sc.nextLine();
                            String enderecoAt = sc.nextLine();

                            professorBD.updateProfessorEnd(matriculaAt,enderecoAt);
                        }
                        else if(atualizo == 2){ //----------------------ATUALIZANDO CONTATO---------------------
                            matriculaAt = sc.nextInt();
                            sc.nextLine();
                            String contatoAt = sc.nextLine();

                            professorBD.updateProfessorCont(matriculaAt, contatoAt);
                        }
                    } else if (opcao1 == 4) {//----------------EXCLUINDO PROFESSOR CADASTRADO------------------
                        System.out.println("Digite o número de identificação do professor a ser deletado:");
                        int id = sc.nextInt();
                        professorBD.deleteProfessor(id);
                    }
                }
                case 3 -> //-------------------------------------SAIR----------------------------------------
                        flag = false;
            }
        }
    }
}
