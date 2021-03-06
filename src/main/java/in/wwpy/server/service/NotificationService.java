package in.wwpy.server.service;

import in.wwpy.server.model.Contract;
import in.wwpy.server.model.Notification;
import in.wwpy.server.model.Offer;

import java.util.List;

public interface NotificationService {

    Notification addNotification(Long userId, Contract contract, Offer offer, String message);

    Long countNotificationByUserId(Long userId);

    Long countNotificationByUserIdAndIsMarkedReadFalse(Long userId);

    void deleteNotification(Long id);

    void deleteNotificationByContractId(Long contractId);

    void deleteNotificationByOfferId(Long offerId);

    List<Notification> findNotificationByUserId(Long userId, int page);

    void markNotificationsAsRead(List<Long> notificationIds);
}
