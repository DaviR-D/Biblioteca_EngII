public class EmprestimoSubject {
    private List<Observer> observers = new ArrayList<>();

    public void registrarObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void notificarObservers() {
        for (Observer obs : observers) {
            obs.atualizar();
        }
    }
    
}