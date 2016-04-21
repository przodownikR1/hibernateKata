package pl.java.scalatech.pitfalls;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.EntityManagerTestCase;
import pl.java.scalatech.domain.pitfalls.Player;
import pl.java.scalatech.domain.pitfalls.Team;

@Slf4j
public class TeamAutoTest extends EntityManagerTestCase{
    @Test
    public void shouldRepoAutoWired() {
        Assertions.assertThat(getManager()).isNotNull();
    }

    @Test
    public void should_A_Save() {
            Player p1 = Player.builder().name("slawek").build();
            Player p2 = Player.builder().name("agnieszka").build();
            Player p3 = Player.builder().name("kalina").build();
            Team team = Team.builder().name("palestra").players(Lists.newArrayList(p1, p2, p3)).build();
            getManager().persist(team);
            log.info("team : {}",getManager().find(Team.class, 1l));


    }
    @Test
    public void should_B_Load() {
        // given
            log.info("team : {}",getManager().find(Team.class, 1l));
    }

    @Override
    protected Map<String, Object> getOverrideProps() {
        Map<String,Object> addedOrOverridenProperties = new HashMap<>();
        addedOrOverridenProperties.put("hibernate.show_sql", false);
        addedOrOverridenProperties.put("hibernate.generate_statistics", false);

        return addedOrOverridenProperties;
    }
}
