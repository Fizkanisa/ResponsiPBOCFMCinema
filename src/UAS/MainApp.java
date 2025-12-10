/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 *
 * @author zettopiaa
 */

// GUI
public class MainApp extends JFrame {
    
    private CinemaSystem system;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JPanel panelHome, panelMovies, panelSchedules, panelSeats, panelBooking, panelHistory;

    private JList<Movie> movieList;
    private DefaultListModel<Movie> movieModel;

    private JList<Schedule> scheduleList;
    private DefaultListModel<Schedule> scheduleModel;

    private JPanel seatPanel;
    private JTextField txtCustomerName;
    private JTextArea historyArea;

    private String selectedSeat = null;
    private Schedule selectedSchedule = null;

    public MainApp() {
        setTitle("CinemaTicket XXI Style – Red/Black Edition");
        setSize(1200, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        system = new CinemaSystem();

        setLayout(new BorderLayout());

        add(makeHeader(), BorderLayout.NORTH);
        add(makeSidebar(), BorderLayout.WEST);
        add(makeMainPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel makeHeader() {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
        header.setPreferredSize(new Dimension(0, 80));
        header.setBackground(new Color(160, 0, 0)); // Merah gelap

        JLabel title = new JLabel("🎬 CFM CINEMA");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Poppins", Font.BOLD, 32));

        header.add(title);
        return header;
    }

    private JPanel makeSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(Color.BLACK);
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setLayout(new GridLayout(8, 1));

        sidebar.add(makeSidebarButton("🏠 Home", "home"));
        sidebar.add(makeSidebarButton("🎞 Film", "movies"));
        sidebar.add(makeSidebarButton("🕒 Schedule", "schedules"));
        sidebar.add(makeSidebarButton("💺 Seat", "seats"));
        sidebar.add(makeSidebarButton("📝 Booking", "booking"));
        sidebar.add(makeSidebarButton("📄 History", "history"));

        return sidebar;
    }

    private JButton makeSidebarButton(String text, String page) {
        JButton btn = new JButton(text);
        btn.setBackground(Color.BLACK);
        btn.setForeground(new Color(255, 215, 0)); // Emas
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("Poppins", Font.BOLD, 18));

        btn.addActionListener(e -> cardLayout.show(mainPanel, page));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(80, 0, 0)); // Merah gelap hover
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(Color.BLACK);
            }
        });

        return btn;
    }

    private JPanel makeMainPanel() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        panelHome = makeHomePanel();
        panelMovies = makeMoviePanel();
        panelSchedules = makeSchedulePanel();
        panelSeats = makeSeatPanel();
        panelBooking = makeBookingPanel();
        panelHistory = makeHistoryPanel();

        mainPanel.add(panelHome, "home");
        mainPanel.add(panelMovies, "movies");
        mainPanel.add(panelSchedules, "schedules");
        mainPanel.add(panelSeats, "seats");
        mainPanel.add(panelBooking, "booking");
        mainPanel.add(panelHistory, "history");

        return mainPanel;
    }

    private JPanel makeHomePanel() {
    ImageIcon bg = new ImageIcon("src/UAS/images/bioskop.jpg");

    JPanel p = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    };

    p.setLayout(new BorderLayout());

    JLabel lbl = new JLabel("Selamat Datang di CFM Cinema", SwingConstants.CENTER);
    lbl.setFont(new Font("Poppins", Font.BOLD, 38));
    lbl.setForeground(Color.WHITE);

    JLabel sub = new JLabel("Mau Nonton Apa Hari Ini?", SwingConstants.CENTER);
    sub.setFont(new Font("Poppins", Font.PLAIN, 22));
    sub.setForeground(Color.LIGHT_GRAY);

    JPanel textPanel = new JPanel(new GridLayout(2,1));
    textPanel.setOpaque(false); // Penting agar background terlihat
    textPanel.add(lbl);
    textPanel.add(sub);

    p.add(textPanel, BorderLayout.NORTH);

    return p;
}


    private JPanel makeMoviePanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.BLACK);
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel lbl = new JLabel("🎞 DAFTAR FILM", SwingConstants.LEFT);
        lbl.setFont(new Font("Poppins", Font.BOLD, 30));
        lbl.setForeground(new Color(255, 215, 0));

        movieModel = new DefaultListModel<>();
        for (Movie m : system.getMovies()) movieModel.addElement(m);

        movieList = new JList<>(movieModel);
        movieList.setFont(new Font("Poppins", Font.PLAIN, 20));
        movieList.setBackground(Color.DARK_GRAY);
        movieList.setForeground(Color.WHITE);

        p.add(lbl, BorderLayout.NORTH);
        p.add(new JScrollPane(movieList), BorderLayout.CENTER);

        return p;
    }

    private JPanel makeSchedulePanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.BLACK);
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel lbl = new JLabel("🕒 JADWAL TAYANG", SwingConstants.LEFT);
        lbl.setFont(new Font("Poppins", Font.BOLD, 30));
        lbl.setForeground(new Color(255, 215, 0));

        scheduleModel = new DefaultListModel<>();
        scheduleList = new JList<>(scheduleModel);
        scheduleList.setFont(new Font("Poppins", Font.PLAIN, 20));
        scheduleList.setBackground(Color.DARK_GRAY);
        scheduleList.setForeground(Color.WHITE);

        movieList.addListSelectionListener(e -> updateSchedules());

        p.add(lbl, BorderLayout.NORTH);
        p.add(new JScrollPane(scheduleList), BorderLayout.CENTER);

        return p;
    }

    private void updateSchedules() {
        scheduleModel.clear();
        Movie selected = movieList.getSelectedValue();
        if (selected != null) {
            for (Schedule s : system.getSchedulesForMovie(selected)) { //ENKAPSULASI DAN INHERITANCE
                scheduleModel.addElement(s);
            }
        }
    }

    private JPanel makeSeatPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.BLACK);
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel lbl = new JLabel("💺 PILIH KURSI", SwingConstants.CENTER);
        lbl.setFont(new Font("Poppins", Font.BOLD, 30));
        lbl.setForeground(new Color(255, 215, 0));

        seatPanel = new JPanel(new GridLayout(5, 8, 10, 10));
        seatPanel.setBackground(Color.BLACK);

        scheduleList.addListSelectionListener(e -> renderSeats());

        p.add(lbl, BorderLayout.NORTH);
        p.add(seatPanel, BorderLayout.CENTER);

        return p;
    }

    private void renderSeats() {
        seatPanel.removeAll();
        selectedSchedule = scheduleList.getSelectedValue();
        if (selectedSchedule == null) return;

        for (Seat s : selectedSchedule.getSeats()) {
            JButton btnSeat = new JButton(s.getSeatNumber());
            btnSeat.setFont(new Font("Poppins", Font.BOLD, 16));
            btnSeat.setForeground(Color.WHITE);

            if (s.isBooked()) {
                btnSeat.setBackground(new Color(120, 0, 0)); // kursi merah gelap booked
                btnSeat.setEnabled(false);
            } else {
                btnSeat.setBackground(new Color(0, 100, 0)); // hijau
            }

            btnSeat.addActionListener(e -> {
                selectedSeat = s.getSeatNumber();
                btnSeat.setBackground(new Color(255, 215, 0)); // emas
            });

            seatPanel.add(btnSeat);
        }

        seatPanel.revalidate();
        seatPanel.repaint();
    }

    private JPanel makeBookingPanel() {
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(40, 200, 40, 200));

        JLabel lbl = new JLabel("📝 PEMESANAN TIKET", SwingConstants.CENTER);
        lbl.setFont(new Font("Poppins", Font.BOLD, 30));
        lbl.setForeground(new Color(255, 215, 0));

        txtCustomerName = new JTextField();
        txtCustomerName.setMaximumSize(new Dimension(400, 40));
        txtCustomerName.setFont(new Font("Poppins", Font.PLAIN, 18));
        txtCustomerName.setBackground(Color.DARK_GRAY);
        txtCustomerName.setForeground(Color.WHITE);
        txtCustomerName.setCaretColor(Color.WHITE);

        JButton btnBook = new JButton("Pesan Tiket");
        btnBook.setFont(new Font("Poppins", Font.BOLD, 22));
        btnBook.setBackground(new Color(160, 0, 0));
        btnBook.setForeground(Color.WHITE);

        btnBook.addActionListener(e -> doBooking());

        p.add(lbl);
        p.add(Box.createVerticalStrut(20));
        p.add(txtCustomerName);
        p.add(Box.createVerticalStrut(20));
        p.add(btnBook);

        return p;
    }

    private void doBooking() {
        String name = txtCustomerName.getText().trim();
        // EXCEPTION
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!");
            return;
        }
        if (selectedSchedule == null) {
            JOptionPane.showMessageDialog(this, "Pilih jadwal terlebih dahulu!");
            return;
        }
        if (selectedSeat == null) {
            JOptionPane.showMessageDialog(this, "Pilih kursi terlebih dahulu!");
            return;
        }

        Booking booking = new Booking(name, selectedSchedule, selectedSeat);
        boolean success = system.makeBooking(booking);

        if (success) {
            JOptionPane.showMessageDialog(this, "Booking Berhasil!\n" + booking);
            txtCustomerName.setText("");
            selectedSeat = null;
            renderSeats();
        } else {
            JOptionPane.showMessageDialog(this, "Kursi sudah dipesan!");
        }
    }

    private JPanel makeHistoryPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.BLACK);
        p.setBorder(new EmptyBorder(15,15,15,15));

        JLabel lbl = new JLabel("📄 RIWAYAT PEMESANAN");
        lbl.setFont(new Font("Poppins", Font.BOLD, 30));
        lbl.setForeground(new Color(255, 215, 0));

        historyArea = new JTextArea();
        historyArea.setFont(new Font("Poppins", Font.PLAIN, 18));
        historyArea.setBackground(Color.DARK_GRAY);
        historyArea.setForeground(Color.WHITE);

        JButton btnRefresh = new JButton("Refresh Riwayat");
        btnRefresh.setFont(new Font("Poppins", Font.BOLD, 18));
        btnRefresh.setBackground(new Color(160, 0, 0));
        btnRefresh.setForeground(Color.WHITE);
        btnRefresh.addActionListener(e -> loadHistory());

        p.add(lbl, BorderLayout.NORTH);
        p.add(new JScrollPane(historyArea), BorderLayout.CENTER);
        p.add(btnRefresh, BorderLayout.SOUTH);

        loadHistory();
        return p;
    }

    private void loadHistory() {
        historyArea.setText("");
        for (String line : system.readBookingLines()) {
            historyArea.append(line + "\n");
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
