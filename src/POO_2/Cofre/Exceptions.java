class BrokedException extends Exception{
    @Override
    public String getMessage(){
        return "fail: the pig is already broken";
    }
}

class FullPigexception extends Exception{
    @Override
    public String getMessage(){
        return "fail: the pig is full";
    }
}

class BreakPigException extends Exception{
    boolean broked = false;

    BreakPigException(boolean broked){
        this.broked = broked;
    }

    @Override
    public String getMessage(){
        if(broked)
            return "fail: the pig is broken";
        else
            return "fail: you must break the pig first";
    }   
}