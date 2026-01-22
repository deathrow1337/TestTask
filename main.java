import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Wallet AramWallet = new Wallet(1, 1000);
	    AramWallet.SpendMoney(1337, 235, "Покупка шаурмы");
	    System.out.println(AramWallet.GetMoney());
	    AramWallet.ShowHistory();
		// your code goes here

	}
}

class HistoryBlock{
    private String timestamp;
    private String comment;
    private float value;
    private int target;
    HistoryBlock(int target, float value, String comment, String timestamp){
        this.timestamp = timestamp;
        this.comment = comment;
        this.value = value;
        this.target = target;
    }
    public String ToString(){
        return "[" + timestamp + "] Трата к \"" + this.target + "\" на сумму " + this.value + "₽ (" + this.comment + ")";
    }
}

class Wallet{
    private float money;
    private int id;
    private ArrayList<HistoryBlock> History = new ArrayList<>();
    Wallet(int WalletID, float startMoney){
        this.money = startMoney;
        this.id = WalletID;
    }
    public int GetID(){
        return this.id;
    }
    public float GetMoney(){
        return this.money;
    }
    private void SetMoney(float value){
        this.money = value;
    }
    private ArrayList<HistoryBlock> GetHistory(){
        return this.History;
    }
    private void AddHistoryBlock(HistoryBlock block){
        this.History.add(block);
    }
    public void ShowHistory(){
        for (HistoryBlock block : this.GetHistory()){
            System.out.println(block.ToString());
        }
    }
    private int SubMoney(float value){
        if (value <= 0){
            return 1;
        }
        float currentMoney = this.GetMoney();
        if (currentMoney - value < 0){
            return 2;
        }
        this.SetMoney(this.GetMoney() - value);
        return 0;
    }
    public void SpendMoney(int target, float value, String comment){
        System.out.println("Проводим трату...");
        int error_code = this.SubMoney(value);
        switch(error_code){
            case 1:
                System.out.println("Недопустимое значение.");
                return;
            case 2:
                System.out.println("Ошибка! Недостаточно средств.");
                return;
            default:
                System.out.println("Успешно выполнено!");
        }
        this.AddHistoryBlock(new HistoryBlock(target, value, comment, "СЕЙЧАС"));
    }
}
