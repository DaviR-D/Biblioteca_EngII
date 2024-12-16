package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoSubject {
    private List<Observer> observers = new ArrayList<>();

    public void registrarObserver(Observer observer) {
        observers.add(observer);
    }

    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar();
        }
    }
}
