package org.example;

import camundajar.impl.scala.Console;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Component("buscarEndereco")
public class BuscarEndereco implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(BuscarEndereco.class.getName());
    private ViaCepController viaCepController;

    public void execute(DelegateExecution execution) throws Exception {

        String cep = (String)execution.getVariable("cep");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/endereco/"+cep;
        Endereco endereco = restTemplate.getForObject(url, Endereco.class);

        assert endereco != null;
        execution.setVariable("bairro", endereco.getBairro());

    }

}
