package POO_2.Agiota;

class ClienteInexistenteException extends Exception {
    @Override
    public String getMessage() {
        return "fail: cliente nao existe";
    }
}

class ClienteException extends Exception {
    private boolean existe;

    public ClienteException(boolean existe) {
        this.existe = existe;
    }

    @Override
    public String getMessage() {
        if (this.existe)
            return "fail: cliente ja existe";
        else
            return "fail: cliente nao existe";
    }
}

