package me.bbang.springbootstartjpa;

import me.bbang.springbootstartjpa.account.Account;
import me.bbang.springbootstartjpa.account.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJdbcTest
public class AccountRepositoryTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di(){
        Account account = new Account();
        account.setUsername("bang");
        account.setPassword("pass");

        Account save = accountRepository.save(account);

        assertThat(save).isNotNull();

        Account existAccount = accountRepository.findByUsername(save.getUsername());
        assertThat(existAccount).isNotNull();

        Account nonExistAccount = accountRepository.findByUsername("bbang");
        assertThat(nonExistAccount).isNull();
    }
}
