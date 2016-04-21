package pl.java.scalatech.pitfalls;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.JPAUnitTestCase;
import pl.java.scalatech.domain.pitfalls.Player;
import pl.java.scalatech.domain.pitfalls.Team;

@FixMethodOrder(NAME_ASCENDING)
@Slf4j
public class TeamTest extends JPAUnitTestCase {

    @Test
    public void shouldRepoAutoWired() {
        Assertions.assertThat(entityManagerFactory).isNotNull();
    }

    @Test
    public void should_A_Save() {
        // given
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Player p1 = Player.builder().name("slawek").build();
            Player p2 = Player.builder().name("agnieszka").build();
            Player p3 = Player.builder().name("kalina").build();
            Team team = Team.builder().name("palestra").players(Lists.newArrayList(p1, p2, p3)).build();

            entityManager.persist(team);
            log.info("team : {}",entityManager.find(Team.class, 1l));
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            log.info("{}", ex);
        } finally {
            entityManager.close();
        }

    }
    @Test
    public void should_B_Load() {
        // given
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            //when
            log.info("team : {}",entityManager.find(Team.class, 1l));
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            log.info("{}", ex);
        } finally {
            entityManager.close();
        }

    }

}
