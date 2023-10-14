package rl.prog2.tutorium.tutorium230322.tutorium;

public class Naturals implements Sequence{

    private int count = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int nextElement() {
        return count++;
    }
}
