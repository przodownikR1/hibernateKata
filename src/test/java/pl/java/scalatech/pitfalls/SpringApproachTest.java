package pl.java.scalatech.pitfalls;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.JpaEmbeddedConfig;
import pl.java.scalatech.config.PropertiesLoader;
import pl.java.scalatech.domain.pitfalls.Player;
import pl.java.scalatech.domain.pitfalls.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PropertiesLoader.class, JpaEmbeddedConfig.class })
@ActiveProfiles(value = "test")
@Transactional
@FixMethodOrder(NAME_ASCENDING)
@Slf4j
public class SpringApproachTest {
    @Autowired
    private EntityManager em;

    @Test
    public void shouldEmAutoWired() {
        Assertions.assertThat(em).isNotNull();
    }

    @Test
    public void should_A_Save() {
        Player p1 = Player.builder().name("slawek").build();
        Player p2 = Player.builder().name("agnieszka").build();
        Player p3 = Player.builder().name("kalina").build();
        Team team = Team.builder().name("palestra").players(Lists.newArrayList(p1, p2, p3)).build();
        em.persist(team);
        log.info("team : {}", em.find(Team.class, 1l));

    }

    @Test
    public void should_B_Load() {
        // given
        log.info("team : {}", em.find(Team.class, 1l));
    }

}
