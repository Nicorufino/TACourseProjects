package com.solvd.socialNetwork;

import com.solvd.socialNetwork.accounts.Account;
import com.solvd.socialNetwork.accounts.BusinessAccount;
import com.solvd.socialNetwork.accounts.UserAccount;
import com.solvd.socialNetwork.enums.Day;
import com.solvd.socialNetwork.exceptions.InvalidIdsException;
import com.solvd.socialNetwork.exceptions.InvalidRegionException;
import com.solvd.socialNetwork.exceptions.InvalidUrlException;
import com.solvd.socialNetwork.exceptions.NotInGroupException;
import com.solvd.socialNetwork.generics.AccountGeneric;
import com.solvd.socialNetwork.generics.MessageGeneric;
import com.solvd.socialNetwork.generics.PostGeneric;
import com.solvd.socialNetwork.lambdaFunctions.FindAccs;
import com.solvd.socialNetwork.lambdaFunctions.FindPostsAcc;
import com.solvd.socialNetwork.lambdaFunctions.FindPostsText;
import com.solvd.socialNetwork.messages.GroupMessage;
import com.solvd.socialNetwork.posts.AdvertisementPost;
import com.solvd.socialNetwork.posts.Post;

import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Runner {
    private final static Logger LOGGER = Logger.getLogger(Runner.class.getName());

    public final static void main(String[] args) throws InvalidRegionException, InvalidUrlException, InvalidIdsException {

        SocialNetwork socialNetwork = new SocialNetwork();

        UserAccount nico = new UserAccount("NicoRufino", 1203123L, false);

        UserAccount lorem = new UserAccount("LoremIpsum", 1235567L, true);

        BusinessAccount solvd = new BusinessAccount("Solvd", 1323123L, "IT Company" );

        socialNetwork.accounts.add(nico);
        socialNetwork.accounts.add(lorem);
        socialNetwork.accounts.add(solvd);

        Post firstPost = nico.post("This is my first post");
        AdvertisementPost solvdLink = solvd.advertisement("This is our web page", "https://www.solvd.com");

        solvd.likePost(firstPost);
        lorem.likePost(firstPost);

        socialNetwork.posts.put(solvdLink, solvdLink.getAuthor());
        socialNetwork.posts.put(firstPost, firstPost.getAuthor());

        LOGGER.debug(firstPost.toString());

        ArrayList<Long> members = new ArrayList<Long>();
        members.add(lorem.getId());
        GroupMessage newGroup = new GroupMessage();
        try {
            newGroup = lorem.createGroup(members);
            // this account isn't in the group so it should throw a NotInGroupException
            nico.leaveGroup(newGroup);
        } catch (InvalidIdsException | NotInGroupException e) {
            LOGGER.error(e);
        }


        Node<String> f = new Node<String>(null, null, "First");
        Node<String> s = new Node<String>(f, null, "Second");
        Node<String> l = new Node<String>(s, null, "Third");
        f.setNext(s);
        s.setNext(l);


        LinkedList<String> linkedList = new LinkedList<String>(f, l);

        linkedList.print();
        LOGGER.debug("--------------");
        Node<String > extra = new Node<String>(null, null, "1,5th");

        linkedList.addBefore(extra, "Second");
        linkedList.print();
        LOGGER.debug("--------------");


        Node<String> extraAfter = new Node<String>(null, null, "2,5th");
        linkedList.addAfter(extraAfter, "Second");
        linkedList.print();

        AccountGeneric<BusinessAccount> solvdGeneric = new AccountGeneric<BusinessAccount>(solvd);
        PostGeneric<AdvertisementPost> solvdAd = new PostGeneric<AdvertisementPost>(solvdLink);
        MessageGeneric<GroupMessage> group = new MessageGeneric<GroupMessage>(newGroup);


        LOGGER.debug(Day.SATURDAY.isWorkingDay());

        FindAccs firstLetter = (ArrayList<Account> list, String criteria) -> list.stream().filter(a -> a.getName().startsWith(criteria)).collect(Collectors.toList());
        ArrayList<Account> a = (ArrayList<Account>) socialNetwork.accounts;
        LOGGER.debug(firstLetter.findAcc(a, "N"));

        FindPostsAcc findByAuthor = (Map<Post, Account> map, Account criteria) -> map.keySet().stream().filter(p -> p.getAuthor().getName().equals(criteria.getName())).collect(Collectors.toList());
        LOGGER.debug(findByAuthor.findPost(socialNetwork.posts, solvd));

        FindPostsText findByText = (Map<Post, Account> map, String criteria) -> map.keySet().stream().filter(p -> p.getText().contains(criteria)).collect(Collectors.toList());
        LOGGER.debug(findByText.findPost(socialNetwork.posts, "first"));




        ExecutorService es = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> cf = new CompletableFuture<>();
        cf.runAsync(() -> {
                LOGGER.debug("1st running, in thread: " + Thread.currentThread().getName());
        }, es);
        cf.runAsync(() -> {
            LOGGER.debug("2nd running, in thread: " + Thread.currentThread().getName());
        }, es);
        cf.runAsync(() -> {
            LOGGER.debug("3rd running, in thread: " + Thread.currentThread().getName());
        }, es);
        cf.runAsync(() -> {
            LOGGER.debug("4th running, in thread: " + Thread.currentThread().getName());
        }, es);

        es.shutdown();

    }

}
