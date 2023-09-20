package br.com.contas.demo.repository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import br.com.contas.demo.Entity.Client;
import br.com.contas.demo.Repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository underTest;

    @Test
    void registraClient () {
//        Client client = new Client("Jose", "459911224630" , "010.254.719-03");

        underTest.save(client);
        boolean expected = underTest.selectExistisCpf(client.getCpf());
        Assertions.assertThat(expected).isTrue();
    }
