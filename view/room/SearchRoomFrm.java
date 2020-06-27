package view.room;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import dao.RoomDAO;
import model.Room;
import model.User;

public class SearchRoomFrm extends JFrame implements ActionListener{
	private ArrayList<Room> listRoom;
	private JTextField txtKey;
	private JButton btnSearch;
	private JTable tblResult;
	private User user;
	private SearchRoomFrm mainFrm;
	
	public SearchRoomFrm(User user){
		super("Search room to edit");
		this.user = user;
		mainFrm = this;
		listRoom = new ArrayList<Room>();
		
		JPanel pnMain = new JPanel();
		pnMain.setSize(this.getSize().width-5, this.getSize().height-20);		
		pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));
		pnMain.add(Box.createRigidArea(new Dimension(0,10)));
		
		JLabel lblHome = new JLabel("Search a room to edit");
		lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);	
		lblHome.setFont (lblHome.getFont ().deriveFont (20.0f));
		pnMain.add(lblHome);
		pnMain.add(Box.createRigidArea(new Dimension(0,20)));
		
		JPanel pn1 = new JPanel();
		pn1.setLayout(new BoxLayout(pn1,BoxLayout.X_AXIS));
		pn1.setSize(this.getSize().width-5, 20);
		pn1.add(new JLabel("Room name: "));
		txtKey = new JTextField();
		pn1.add(txtKey);
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);
		pn1.add(btnSearch);
		pnMain.add(pn1);
		pnMain.add(Box.createRigidArea(new Dimension(0,10)));

		JPanel pn2 = new JPanel();
		pn2.setLayout(new BoxLayout(pn2,BoxLayout.Y_AXIS));		
		tblResult = new JTable();
		JScrollPane scrollPane= new  JScrollPane(tblResult);
		tblResult.setFillsViewportHeight(false); 
		scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 250));
		
		tblResult.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int column = tblResult.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
				int row = e.getY() / tblResult.getRowHeight(); // get the row of the button

				// *Checking the row or column is valid or not
				if (row < tblResult.getRowCount() && row >= 0 && column < tblResult.getColumnCount() && column >= 0) {
					(new EditRoomFrm(user, listRoom.get(row))).setVisible(true);
					mainFrm.dispose();
				}
			}
		});

		pn2.add(scrollPane);
		pnMain.add(pn2);	
		this.add(pnMain);
		this.setSize(600,300);				
		this.setLocation(200,10);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btnClicked = (JButton)e.getSource();
		if(btnClicked.equals(btnSearch)){
			if((txtKey.getText() == null)||(txtKey.getText().length() == 0))
				return;
			RoomDAO rd = new RoomDAO();
			listRoom = rd.searchRoom(txtKey.getText().trim());

			String[] columnNames = {"Id", "Name", "Type", "Price", "Description"};
			String[][] value = new String[listRoom.size()][5];
			for(int i=0; i<listRoom.size(); i++){
				value[i][0] = listRoom.get(i).getId() +"";
				value[i][1] = listRoom.get(i).getName();
				value[i][2] = listRoom.get(i).getType();
				value[i][3] = listRoom.get(i).getPrice() +"";
				value[i][4] = listRoom.get(i).getDes();
			}
			DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //unable to edit cells
			       return false;
			    }
			};
			tblResult.setModel(tableModel);
		}
	}
}
