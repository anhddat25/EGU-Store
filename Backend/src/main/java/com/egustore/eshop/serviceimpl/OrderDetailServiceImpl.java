package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.mapper.OrderDetailMapper;
import com.egustore.eshop.repository.OrderDetailRepository;
import com.egustore.eshop.service.EmailService;
import com.egustore.eshop.service.OrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;
    private final EmailService emailService;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, OrderDetailMapper orderDetailMapper, EmailService emailService) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderDetailMapper = orderDetailMapper;
        this.emailService = emailService;
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) {
//        OrderDetail orderDetail = OrderDetailMapper.INSTANCE.toEntity(orderDetailDTO);
//        return orderDetailRepository.save(orderDetail);
        OrderDetail orderDetail = OrderDetailMapper.INSTANCE.toEntity(orderDetailDTO);
        OrderDetail savedOrderDetail = orderDetailRepository.save(orderDetail);

        // Lấy thông tin Order tương ứng với OrderDetail
        Order order = savedOrderDetail.getOrder(); // Giả sử có phương thức getOrder()

        // Tạo nội dung email từ thông tin Order và OrderDetail
        String emailContent = createEmailContent(order, savedOrderDetail);

        // Gửi email tới địa chỉ email của khách hàng
        String customerEmail = "haonvps24050@fpt.edu.vn"; // Lấy địa chỉ email của khách hàng từ Order

        // Gửi email
        emailService.sendEmail(customerEmail, "Thông tin đơn hàng mới", emailContent);

        return savedOrderDetail;
    }
    private String createEmailContent(Order order, OrderDetail orderDetail) {
        // Tạo nội dung email từ thông tin Order và OrderDetail
        // Ví dụ:
        String content = "Chi tiết đơn hàng của bạn:\n";
        content += "Đơn hàng số: " + order.getId() + "\n";
        content += "Người đặt hàng: " + order.getName() + "\n";
        content += "Ngày đặt hàng: " + order.getOrderDate() + "\n";
        content += "Địa chỉ nhận hàng: " + order.getAddress() + "\n";
        content += "Tổng hóa đơn đặt hàng: " + order.getTotalAmount() + "\n";

        // Thêm thông tin khác cần thiết
//        content += "Chi tiết sản phẩm: " + orderDetail.getProductDetails() + "\n";
        // ...Thêm thông tin khác

        return content;
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDetail not found"));

    }

    @Override
    public List<OrderDetailDTO> getOrderDetailByOrderID(Integer id) {
        return orderDetailMapper.toDTOList(orderDetailRepository.getOrderDetailByOrderID(id));
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

//    @Override
//    public Integer updateOrderDetail(int id, OrderDetailDTO orderDetailDTO) {
//        r
//    }

    @Override
    public void deleteOrderDetail(int id) {
        orderDetailRepository.deleteById(id);
    }
    @Override
    public Integer updateQuantityDetail(OrderDetailDTO orderDetailDTO, int id) {
        return orderDetailRepository.updateQuantityDetail(orderDetailDTO, id);
    }
}
