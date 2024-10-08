package cibertec.edu.pe.T2_JV_JM.exception;

public class ResourceNotFoundException
    extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
