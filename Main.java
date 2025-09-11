
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static double saldo = 1000.0; 
    // Saldo inicial
    private static List <String> extrato = new ArrayList<>();
    // Lista para armazenar o extrato de transações
    private static Scanner sc = new Scanner(System.in);
    // Scanner para leitura de entrada do usuário
    
    public static void main(String[] args) {
        System.out.println("=== BEM-VINDO AO CAIXA ELETRÔNICO ===");
        
        // Adiciona transação inicial no extrato
        extrato.add("Saldo inicial: R$ " + String.format("%.2f", saldo));
        
        int opcao;
        do {
            exibirMenu();
            opcao = sc.nextInt();
            
            switch(opcao) {
                    
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    verExtrato();
                    break;
                case 5:
                    System.out.println("Obrigado por usar nossos serviços!");
                    break;
                default:
                
                    System.out.println("Opção inválida! Tente novamente.");
            }
            
            if(opcao != 5) {
                // Aguarda o usuário pressionar Enter para continuar
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine(); // 
                sc.nextLine(); // 
            }
            
        } while(opcao != 5);
 
        
        sc.close();
    }
    
    public static void exibirMenu() {
        System.out.println("\n=====================================");
        System.out.println("           MENU PRINCIPAL");
        System.out.println("=====================================");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Sacar Dinheiro");
        System.out.println("3. Depositar Dinheiro");
        System.out.println("4. Ver Extrato");
        System.out.println("5. Sair");
        System.out.println("=====================================");
        System.out.print("Escolha uma opção: ");
    }
    
    public static void consultarSaldo() {
        System.out.println("\n -- CONSULTA DE SALDO ---");
        System.out.println("Seu saldo atual é: R$ " + String.format("%.2f", saldo));
    }
    
    public static void sacar() {
        System.out.println("\n--- SAQUE ---");
        System.out.print("Digite o valor para saque: R$ ");
        double valor = sc.nextDouble();
        
        if(valor <= 0) {
            System.out.println("Valor inválido! Digite um valor maior que zero.");
        } else if(valor > saldo) {
            System.out.println("Saldo insuficiente! Seu saldo atual é: R$ " + String.format("%.2f", saldo));
        } else {
            saldo -= valor;
            extrato.add("Saque: -R$ " + String.format("%.2f", valor) + " | Saldo: R$ " + String.format("%.2f", saldo));
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Valor sacado: R$ " + String.format("%.2f", valor));
            System.out.println("Saldo restante: R$ " + String.format("%.2f", saldo));
        }
    }
    
    public static void depositar() {
        System.out.println("\n--- DEPÓSITO ---");
        System.out.print("Digite o valor para depósito: R$ ");
        double valor = sc.nextDouble();
        
        if(valor <= 0) {
            System.out.println("Valor inválido! Digite um valor maior que zero.");
        } else {
            saldo += valor;
            extrato.add("Depósito: +R$ " + String.format("%.2f", valor) + " | Saldo: R$ " + String.format("%.2f", saldo));
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Valor depositado: R$ " + String.format("%.2f", valor));
            System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
        }
    }
    
    public static void verExtrato() {
        System.out.println("\n--- EXTRATO BANCÁRIO ---");
        System.out.println("=====================================");
        
        if(extrato.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            for(int i = 0; i < extrato.size(); i++) {
                System.out.println((i + 1) + ". " + extrato.get(i));
            }
        }
        
        System.out.println("=====================================");
        System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
    }
}


