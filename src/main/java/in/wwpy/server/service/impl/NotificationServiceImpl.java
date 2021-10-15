package in.wwpy.server.service.impl;

import in.wwpy.server.model.Contract;
import in.wwpy.server.model.Notification;
import in.wwpy.server.model.Offer;
import in.wwpy.server.repository.NotificationRepository;
import in.wwpy.server.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static in.wwpy.server.constant.NotificationConstant.THIS_NOTIFICATION_DOES_NOT_EXIST;


@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final int DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification addNotification(Long userId, Contract contract, Offer offer, String message) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setContract(contract);
        notification.setOffer(offer);
        notification.setMessage(message);
        notification.setMarkedRead(false);
        notificationRepository.save(notification);
        return notification;
    }

    @Override
    public Long countNotificationByUserId(Long userId) {
        return notificationRepository.countNotificationByUserId(userId);
    }

    @Override
    public Long countNotificationByUserIdAndIsMarkedReadFalse(Long userId) {
        return notificationRepository.countNotificationByUserIdAndIsMarkedReadFalse(userId);
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> findNotificationByUserId(Long userId, int page) {
        Pageable pageable = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        return notificationRepository.findNotificationByUserIdOrderByCreatedDateDesc(userId, pageable);
    }

    @Override
    public List<Notification> markNotificationsAsRead(List<Long> notificationIds) {
        List<Notification> markedAsRead = new ArrayList<>();
        notificationIds.forEach(id -> {
            if (notificationRepository.findById(id).isPresent()) {
                Notification notification = notificationRepository.findById(id).get();
                notification.setMarkedRead(true);
                notificationRepository.save(notification);
                markedAsRead.add(notification);
            } else {
                LOGGER.error(THIS_NOTIFICATION_DOES_NOT_EXIST);
            }
        });
        return markedAsRead;
    }
}
