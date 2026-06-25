package org.example.kafkastub.repository;

import org.springframework.stereotype.Repository;
import org.example.kafkastub.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    boolean existsByMsgId(String msgId);
}
