package de.dytanic.cloudnet.event;

/**
 * Created by Tareko on 26.07.2017.
 */
public interface Cancelable {

    boolean isCancelled();

    void setCancelled(boolean cancel);

}