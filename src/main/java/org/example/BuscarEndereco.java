package org.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("buscarEndereco")
public class BuscarEndereco implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(BuscarEndereco.class.getName());

    public void execute(DelegateExecution execution) throws Exception {

        String nome = (String)execution.getVariable("teste");

        LOGGER.info("Variavel nome:" + nome);

    }

}
