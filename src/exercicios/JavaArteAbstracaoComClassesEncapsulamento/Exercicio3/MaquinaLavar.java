package exercicios.JavaArteAbstracaoComClassesEncapsulamento.Exercicio3;

public class MaquinaLavar {
    private Pet pet;
    private int nivelAgua;
    private int nivelShampoo;
    private boolean petNaMaquina;
    private boolean maquinaLimpa;

    public MaquinaLavar() {
        this.nivelAgua = 0;
        this.nivelShampoo = 0;
        this.petNaMaquina = false;
        this.maquinaLimpa = true;
    }    

    public int getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(int nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    public int getNivelShampoo() {
        return nivelShampoo;
    }

    public void setNivelShampoo(int nivelShampoo) {
        this.nivelShampoo = nivelShampoo;
    }

    public boolean isPetNaMaquina() {
        return petNaMaquina;
    }

    public void setPetNaMaquina(boolean petNaMaquina) {
        this.petNaMaquina = petNaMaquina;
    }

    public boolean isMaquinaLimpa() {
        return maquinaLimpa;
    }

    public void setMaquinaLimpa(boolean maquinaLimpa) {
        this.maquinaLimpa = maquinaLimpa;
    }

    public void darBanho(Pet pet){
        if (!maquinaLimpa) {
            System.out.println("Máquina suja");
            return;
        }

        if (nivelAgua < 10 || nivelShampoo < 2) {
            System.out.println("Nível de água ou shampoo insuficiente");
            return;
        }

        if (this.petNaMaquina) {
            System.out.println("Dando banho no pet");
            nivelAgua -= 10;
            nivelShampoo -= 2;
            maquinaLimpa = false;
        } else {
            System.out.println("Coloque o pet na máquina");
        }
    }

    public void colocarPetNaMaquina(Pet pet){
        if (this.petNaMaquina) {
            System.out.println("Pet já está na máquina");
            return;
        }
        this.pet = pet;
        this.petNaMaquina = true;
        System.out.println("Pet colocado na máquina");
    }

    public void retirarPetDaMaquina(){
        if (!this.petNaMaquina) {
            System.out.println("Não tem pet na máquina");
            return;
        }
        this.pet = null;
        this.petNaMaquina = false;
        System.out.println("Pet retirado da máquina");
    }

    public void verificarSeTemPetNoBanho(){
        if (this.petNaMaquina) {
            System.out.println("Tem pet na máquina");
        } else {
            System.out.println("Não tem pet na máquina");
        }
    }

    public void abastecerAgua(){
        if (nivelAgua >= 30) {
            System.out.println("Máquina já está abastecida com água");
            return;
        }
        System.out.println("Abastecendo com água");
        nivelAgua += 2;
    }

    public void abastecerShampoo(){
        if (nivelShampoo >= 10) {
            System.out.println("Máquina já está abastecida com shampoo");
            return;
        } else {
            System.out.println("Abastecendo com shampoo");
            nivelShampoo += 2;
        }
    }

    public void verificarNivelAgua(){
        System.out.println("Nível de água: " + nivelAgua);
    }

    public void verificarNivelShampoo(){
        System.out.println("Nível de shampoo: " + nivelShampoo);
    }

    public void limparMaquina(){
        if (maquinaLimpa) {
            System.out.println("Máquina já está limpa");
            return;
        }
        if (nivelAgua < 3 || nivelShampoo < 1) {
            System.out.println("Nível de água ou shampoo insuficiente");
            return;
        }

        nivelAgua -= 3;
        nivelShampoo -= 1;
        maquinaLimpa = true;
        System.out.println("Limpando máquina");
    }
}
