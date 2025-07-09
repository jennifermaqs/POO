class BalanceException extends Exception{
    public String getMessage(){
        return "fail: saldo insuficiente";
    }
}

class FoundException extends Exception{
    public String getMessage(){
        return "fail: conta nao encontrada";
    }
}