package com.kh.app22.notice.repository;

import com.kh.app22.notice.entity.NoticeEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeRepository {
    private final EntityManager em;

    public void insert(NoticeEntity entity) {
        em.persist(entity);
    }

    public List<NoticeEntity> getNoticeAll() {
        String jpql = "SELECT n FROM NoticeEntity n";
        return em.createQuery(jpql, NoticeEntity.class).getResultList();
        /*
        * em.createQuery(jpql, NoticeEntity.class).getResultList();
        * --> jpql(문자열)을 EM한테 전달하고 NoticeEntity.class의 리스트 결과를 받아온다
        * <jpql 전달 == 엔티티매니저야 이거(jpql)보고 SQL 잘 만들어서 실행해줘>
        *
        * 자바를 다룰 수 있는 JPQL로 EM에게 vo를 관리하게 한다
        * "SELECT n FROM NoticeEntity n"
        * --> NoticeEntity를 n으로 변수로 두고 해당 객체를 통째로 가져오겠다
        * */
    }

    public NoticeEntity getNoticeByNo(Long no) {
        return em.find(NoticeEntity.class, no);
                //no로 찾아서 단건 조회
    }
}
