package transmorfers;

import java.util.ArrayList;
import java.util.List;

class Switcher {
    private List<ElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricityListener(ElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener(ElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("Выключатель включён!");
        for (ElectricityConsumer oneListener : listeners) {
            oneListener.electricityOn();
        }
    }
}

class Lamp implements ElectricityConsumer {
    public void lightsOn() {
        System.out.println("Лампа зажглась!");
    }

    @Override
    public void electricityOn() {
        lightsOn();
    }
}

class Radio implements ElectricityConsumer {
    public void playMusic() {
        System.out.println("Радио играет музыку!");
    }

    @Override
    public void electricityOn() {
        playMusic();
    }
}

interface ElectricityConsumer {
    void electricityOn();
}

class Main {
    public static void main(String[] args) {
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        // Подписка на событие (event subscribe)
        sw.addElectricityListener(lamp);
        sw.addElectricityListener(radio);

        // Добавляем в список потребителей электричества анонимный(одноразовый) класс
        sw.addElectricityListener(
                new ElectricityConsumer() {

                    @Override
                    public void electricityOn() {
                        // Выводим одноразовое сообщение
                        System.out.println("Пожар!");
                    }
                }
        );

        sw.switchOn();
    }
}