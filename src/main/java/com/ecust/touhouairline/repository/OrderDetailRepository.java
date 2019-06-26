package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,String> {
    OrderDetailEntity findByDetailNo(Integer detailNo);
    @Query(value = "SELECT od.detailNo FROM flight f,ordermaster om,orderdetail od " +
            "where f.flightNo=?1 and om.flightNo =f.flightNo  and om.orderNo = od.orderNo and od.passport=?2", nativeQuery = true)
    Integer findByPassport(String flightNo, String passport);
    @Query(value = "SELECT od.detailNo FROM flight f,ordermaster om,orderdetail od " +
            "where f.flightNo=?1 and om.flightNo =f.flightNo  and om.orderNo = od.orderNo and od.identity=?2", nativeQuery = true)
    Integer findByIdentity(String flightNo, String passport);
    @Query(value = "SELECT count(*) FROM flight f,ordermaster om,orderdetail od " +
            "where f.flightNo=?1 and om.flightNo =f.flightNo  and om.orderNo = od.orderNo and od.seat>0", nativeQuery = true)
    Integer countAllByFlightno(String flightNo);

}
