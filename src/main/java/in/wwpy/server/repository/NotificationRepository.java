package in.wwpy.server.repository;

import in.wwpy.server.model.Notification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "notification-resource")
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Long countNotificationByUserId(Long userId);
    Long countNotificationByUserIdAndIsMarkedReadFalse(Long userId);

    List<Notification> findNotificationByUserId(Long userId, Pageable pageable);
    List<Notification> findNotificationByUserIdOrderByCreatedDateDesc(Long userId, Pageable pageable);
}
