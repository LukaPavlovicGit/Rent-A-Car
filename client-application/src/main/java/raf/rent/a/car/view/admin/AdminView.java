package raf.rent.a.car.view.admin;

import raf.rent.a.car.MainFrame;
import raf.rent.a.car.controller.*;
import raf.rent.a.car.dto.*;
import raf.rent.a.car.utils.MyPanel;
import raf.rent.a.car.utils.MyTable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdminView extends MyPanel {

    public AdminView(){
        init();
    }

    private void init(){
        this.setBounds(450, 190, 1014, 597);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        this.setBackground(Color.lightGray);
        this.add(getContentPanel());

        JLabel titleLbl = new JLabel("Admin View");
        titleLbl.setBackground(Color.BLACK);
        titleLbl.setForeground(Color.RED);
        titleLbl.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        titleLbl.setBounds(400, 20, 590, 103);
        this.add(titleLbl);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1010, 26);
        this.add(menuBar);

        // user service
        JMenu userServiceJMenu = new JMenu("User service");
        userServiceJMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(userServiceJMenu);

        JMenu users = new JMenu("Users");
        users.setFont(new Font("Segoe UI", Font.BOLD, 16));
        userServiceJMenu.add(users);

        JMenuItem allUsers = new JMenuItem("All users");
        users.add(allUsers);
        allUsers.addActionListener(new AllUsersClicked());

        JMenuItem accountBlocking = new JMenuItem("Account blocking");
        users.add(accountBlocking);
        accountBlocking.addActionListener(new AccountBlockingClicked());

        JMenu ranks = new JMenu("Ranks");
        ranks.setFont(new Font("Segoe UI", Font.BOLD, 16));
        userServiceJMenu.add(ranks);

        // reservation service
        JMenu reservationServiceJMenu = new JMenu("Booking service");
        reservationServiceJMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(reservationServiceJMenu);

        JMenuItem allCompanies = new JMenuItem("All companies");
        allCompanies.setFont(new Font("Segoe UI", Font.BOLD, 15));
        reservationServiceJMenu.add(allCompanies);
        allCompanies.addActionListener(new AllCompaniesClicked());


        JMenuItem allReservations = new JMenuItem("All reservations");
        allReservations.setFont(new Font("Segoe UI", Font.BOLD, 15));
        reservationServiceJMenu.add(allReservations);
        allReservations.addActionListener(new AllReservationsClicked());


        JMenuItem allReviews = new JMenuItem("Reviews");
        allReviews.setFont(new Font("Segoe UI", Font.BOLD, 15));
        reservationServiceJMenu.add(allReviews);
        allReviews.addActionListener(new AllReviewsClicked());

        JMenu vehicles = new JMenu("Vehicles");
        vehicles.setFont(new Font("Segoe UI", Font.BOLD, 16));
        reservationServiceJMenu.add(vehicles);

        // notification service
        JMenu notificationServiceJMenu = new JMenu("Notification service");
        notificationServiceJMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(notificationServiceJMenu);

        JMenu emailPatters = new JMenu("Emails");
        emailPatters.setFont(new Font("Segoe UI", Font.BOLD, 16));
        notificationServiceJMenu.add(emailPatters);

        JMenu sentEmails = new JMenu("Sent emails");
        sentEmails.setFont(new Font("Segoe UI", Font.BOLD, 16));
        notificationServiceJMenu.add(sentEmails);

        // my account

        JMenu myAccountJMenu = new JMenu("My account");
        myAccountJMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(myAccountJMenu);

        JMenuItem logout = new JMenuItem("Logout");
        myAccountJMenu.add(logout);
        logout.addActionListener(new LogoutClicked());

        JMenuItem profileUpdate = new JMenuItem("Profile update");
        myAccountJMenu.add(profileUpdate);
        profileUpdate.addActionListener(new AdminProfileUpdateClicked());

        JMenuItem changePassword = new JMenuItem("Password change");
        myAccountJMenu.add(changePassword);
        changePassword.addActionListener(new PasswordChangeClicked());

        JMenuItem deleteAccount = new JMenuItem("Delete account");
        myAccountJMenu.add(deleteAccount);
        deleteAccount.addActionListener(new DeleteAccountClicked());



        //************

    }

}