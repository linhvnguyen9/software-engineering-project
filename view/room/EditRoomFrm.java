package view.room;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dao.RoomDAO;
import model.Room;
import model.User;
import view.user.ManagerHomeFrm;

public class EditRoomFrm extends JFrame implements ActionListener{
	private Room room;
	private JTextField txtId, txtName, txtType, txtPrice, txtDes;
	private JButton btnUpdate, btnReset;
	private User user;
	
	
	public EditRoomFrm(User user, Room room){
		super("Edit a room");
		this.user = user;
		this.room = room;
		
		JPanel pnMain = new JPanel();
		pnMain.setSize(this.getSize().width-5, this.getSize().height-20);		
		pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));
		pnMain.add(Box.createRigidArea(new Dimension(0,10)));
		
		JLabel lblHome = new JLabel("Edit a room");
		lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);	
		lblHome.setFont (lblHome.getFont ().deriveFont (20.0f));
		pnMain.add(lblHome);
		pnMain.add(Box.createRigidArea(new Dimension(0,20)));
		
		txtId = new JTextField(15);
		txtId.setEditable(false);
		txtName = new JTextField(15);
		txtType = new JTextField(15);
		txtPrice = new JTextField(15);
		txtDes = new JTextField(15);
		btnUpdate = new JButton("Update");
		btnReset = new JButton("Reset");
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(6,2));
		content.add(new JLabel("Room ID:")); 	content.add(txtId);
		content.add(new JLabel("Room name:")); 	content.add(txtName);
		content.add(new JLabel("Type:")); 	content.add(txtType);
		content.add(new JLabel("Price:")); 	content.add(txtPrice);
		content.add(new JLabel("Description:")); 	content.add(txtDes);
		content.add(btnUpdate); 	content.add(btnReset);
		pnMain.add(content);		  
		btnUpdate.addActionListener(this);
		btnReset.addActionListener(this);
		
		initForm();		
		this.setContentPane(pnMain);
		this.setSize(600,300);				
		this.setLocation(200,10);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initForm(){
		if(room != null){
			txtId.setText(room.getId()+"");
			txtName.setText(room.getName());
			txtType.setText(room.getType());
			txtPrice.setText(room.getPrice()+"");
			txtDes.setText(room.getDes());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btnClicked = (JButton)e.getSource();
		if(btnClicked.equals(btnReset)){
			initForm();
			return;
		}
		if(btnClicked.equals(btnUpdate)){
			room.setName(txtName.getText());
			room.setType(txtType.getText());
			room.setPrice(Float.parseFloat(txtPrice.getText()));
			room.setDes(txtDes.getText());
			
			RoomDAO rd = new RoomDAO();
			if(rd.updateRoom(room)) {
				JOptionPane.showMessageDialog(this, "The room is succeffully updated!");
				(new ManagerHomeFrm(user)).setVisible(true);
				this.dispose();
			}	
		}
	}
}
