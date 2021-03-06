package by.it.livanovich.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private Good good;
    private boolean pensionner = false;
    static int count = 0;

    private Backet backet = new Backet();

    public Backet getBacket() {
        return backet;
    }

    public Buyer(int number) {
        super("Покупатель № " + number);
        Dispatcher.addBuyer();
        counter();
    }

    public static void counter() {
        count++;
    }

    public void run() {
        if (count % 4 == 0) {
            pensionner = true;
        }
        enterToMarket();
        takeBacket();
        Integer countGoods = Rnd.Rnd(1, 4);
        for (int i = 1; i <= countGoods; i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBacket() {
        int timeout = Rnd.Rnd(100, 200);
        if (pensionner) {
            Rnd.sleep((int) (timeout / Dispatcher.K_SPEED * 1.5));
        } else {
            Rnd.sleep(timeout / Dispatcher.K_SPEED);
        }
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int timeout = Rnd.Rnd(500, 2000);
        if (pensionner) {
            Rnd.sleep((int) (timeout / Dispatcher.K_SPEED * 1.5));
        } else {
            Rnd.sleep(timeout / Dispatcher.K_SPEED);
        }
        good = Goods.getRandomGood();
        System.out.println(this + " выбрал товар " + good);
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Rnd.Rnd(100, 200);
        if (pensionner)
            Rnd.sleep((int) (timeout / Dispatcher.K_SPEED * 1.5));
        else Rnd.sleep(timeout / Dispatcher.K_SPEED);
        System.out.println(this + " положил в корзину " + good);
        backet.putBacket(good);
    }

    @Override
    public void goToQueue() {
        Queue.addBuyer(this);
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
        Dispatcher.deductBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
