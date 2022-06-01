package core.repos;

import core.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MessageRepository extends CrudRepository<Message, Integer> {
        List<Message> findBySender(String sender);

}
