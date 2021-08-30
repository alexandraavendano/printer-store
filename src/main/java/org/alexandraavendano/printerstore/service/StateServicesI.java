package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.State;

public interface StateServicesI {

    Iterable<State> getAll();
}