package in.wwpy.server.controller;

import in.wwpy.server.model.HttpResponse;
import in.wwpy.server.model.Notification;
import in.wwpy.server.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static in.wwpy.server.constant.NotificationConstant.NOTIFICATIONS_MARKED_READ_SUCCESSFULLY;
import static in.wwpy.server.constant.NotificationConstant.NOTIFICATION_DELETED_SUCCESSFULLY;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/notification"})
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @PostMapping("/add")
    public ResponseEntity<Notification> addNotification(@RequestBody Notification notification) {
        Notification newNotification = this.notificationService.addNotification(
                notification.getUserId(),
                notification.getContract(),
                notification.getOffer(),
                notification.getMessage());
        return new ResponseEntity<>(newNotification, OK);
    }

    @GetMapping("/count/user/{id}")
    public ResponseEntity<Long> countNotificationByUserId(@PathVariable("id") Long id) {
        Long count = this.notificationService.countNotificationByUserId(id);
        return new ResponseEntity<>(count, OK);
    }

    @GetMapping("/count/user/{id}/unread")
    public ResponseEntity<Long> countUnreadNotificationByUserId(@PathVariable("id") Long id) {
        Long count = this.notificationService.countNotificationByUserIdAndIsMarkedReadFalse(id);
        return new ResponseEntity<>(count, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteNotification(@PathVariable("id") Long id) {
        this.notificationService.deleteNotification(id);
        return response(NO_CONTENT, NOTIFICATION_DELETED_SUCCESSFULLY);
    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity<List<Notification>> findNotificationByUserId(
            @RequestParam("page") int page,
            @PathVariable("id") Long id
    ) {
        List<Notification> notifications = this.notificationService.findNotificationByUserId(id, page);
        return new ResponseEntity<>(notifications, OK);
    }

    @PostMapping("/mark/read")
    public ResponseEntity<HttpResponse> markNotificationsAsRead(
        @RequestBody List<Long> notificationIds
    ) {
        this.notificationService.markNotificationsAsRead(notificationIds);
        return response(NO_CONTENT, NOTIFICATIONS_MARKED_READ_SUCCESSFULLY);
    }

    // TODO:: MAKE END POINT THAT MARKS ALL NOTIFICATIONS AS READ BY USER ID

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        HttpResponse body = new HttpResponse(
                httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase());
        return new ResponseEntity<>(body, httpStatus);
    }
}
