package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
//            List<Member> result=em.createQuery("select m from Member as m", Member.class).setFirstResult(1).setMaxResults(8).getResultList();
//            for(Member member:result){
//                System.out.println("member.name = " + member.getName());
//            }
//            em.remove(findMember); 제거
//             비영속
//            Member member=new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            em.persist(member);
//            영속
//            Member findMember1=em.find(Member.class,101L);
//            Member findMember2 =em.find(Member.class,101L);
//            System.out.println("result = "+(findMember1==findMember2));
//            Member member1=new Member(300L,"C");
//            Member member2=new Member(360L,"D");
//            em.persist(member1);
//            em.persist(member2);
            Team team=new Team();
            team.setName("TeamA");
            //team.getMembers().add(member);
            em.persist(team);
            Member member=new Member();
            member.setName("Member1");
            em.persist(member);
            team.addMember(member);//연관관계 편의 메소드
            em.flush();
            em.clear();
            tx.commit();
        }
        catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
