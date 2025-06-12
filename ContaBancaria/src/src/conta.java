package src;

public class conta {

    private double saldo;
    private double cheque;
    private double usoDoCheque;

    public conta(double saldoInicial) {
        this.saldo = saldoInicial;
        this.usoDoCheque = 0;

        if (saldoInicial <= 500) {
            this.cheque = 50.0;
        } else {
            this.cheque = saldoInicial * 0.5;
        }
    }

    public double getLimite() {
        return cheque;
    }

    public double getSaldo() {
        return saldo;
    }

    public void consultarCheque() {
        if (usoDoCheque > 0) {
            double porcentagem = (usoDoCheque / cheque) * 100;
            System.out.printf("Você está usando R$%.2f de R$%.2f (%.2f%% do seu cheque especial)%n",
                    usoDoCheque, cheque, porcentagem);
        } else {
            System.out.println("Você não está utilizando o cheque especial.");
        }
    }

    public void depositarDinheiro(double valor) {
        if (valor > 0) {
           
            if (usoDoCheque > 0) {
                double taxa = usoDoCheque * 0.20;
                double totalDivida = usoDoCheque + taxa;

                if (valor >= totalDivida) {
                    valor -= totalDivida;
                    usoDoCheque = 0;
                    System.out.printf("Uso do cheque especial quitado com taxa de R$%.2f%n", taxa);
                } else {
                    usoDoCheque -= valor / 1.20;
                    System.out.println("Parte do uso do cheque foi pago, ainda há dívida.");
                    return;
                }
            }

            this.saldo += valor;
            System.out.printf("Dinheiro depositado com sucesso. Saldo atual: R$%.2f%n", this.saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacarDinheiro(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }

        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque realizado com sucesso. Saldo atual: R$%.2f%n", saldo);
        } else {
            double restante = valor - saldo;

            if (restante <= (cheque - usoDoCheque)) {
                usoDoCheque += restante;
                saldo = 0;
                System.out.printf("Saque usando cheque especial. Uso atual: R$%.2f, Saldo: R$%.2f%n",
                        usoDoCheque, saldo);
            } else {
                System.out.println("Saque excede o limite disponível (saldo + cheque especial).");
            }
        }
    }

    public boolean usandoChequeEspecial() {
        return usoDoCheque > 0;
    }
    
    public void pagarBoleto(double valor) {
        if (valor <= 0) {
            System.out.println("Valor do boleto inválido.");
            return;
        }

        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Boleto de R$%.2f pago com sucesso. Saldo atual: R$%.2f%n", valor, saldo);
        } else {
            double restante = valor - saldo;

            if (restante <= (cheque - usoDoCheque)) {
                usoDoCheque += restante;
                saldo = 0;
                System.out.printf("Boleto de R$%.2f pago usando cheque especial. Uso atual: R$%.2f%n",
                        valor, usoDoCheque);
            } else {
                System.out.println("Não há saldo suficiente nem limite de cheque especial para pagar o boleto.");
            }
        }
    }
}
