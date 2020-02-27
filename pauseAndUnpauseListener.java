pause.addActionListener(new ActionListener() {
			JTextField session_pass = new JTextField("session password");

			@Override
			public void actionPerformed(ActionEvent e) {
				if (queueList.getSelectedValues().length <= 0) {
					JOptionPane.showMessageDialog(null, "Choose one to pause!");
				} else {
					sessionP = new JFrame();
					panels = new JPanel();
					session_pass.setBounds(100, 150, 300, 50);
					panels.add(session_pass);
					sessionP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					submitP = new JButton();
					submitP.setText("submit");
				}
				submitP.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String status = queueList.getSelectedValue()
								.substring(queueList.getSelectedValue().lastIndexOf("(") + 1);
						if (status.equals("paused)")) {
							JOptionPane.showMessageDialog(null, "You are already paused!");
						} else {
//		        		System.out.println(queueList.getSelectedIndex());
							String name = queueList.getSelectedValue() + "(paused)";
							arr.set(queueList.getSelectedIndex(), name);
//			        	System.out.println(arr);
							Object[] objArr = arr.toArray();
							String[] str = Arrays.copyOf(objArr, objArr.length, String[].class);
							queueList.setListData(str);
						}
					}
				});
				panels.setLayout(null);
				submitP.setBounds(200, 200, 80, 50);
				panels.add(submitP);
//		 		session_pass.setBounds(100, 150, 300, 50);
//		 		panels.add(session_pass);
				sessionP.add(panels);
				sessionP.setSize(500, 500);
				sessionP.setVisible(true);

			}
		});

		unpause.addActionListener(new ActionListener() {
			JTextField session_pass = new JTextField("session password");

			@Override
			public void actionPerformed(ActionEvent e) {
				String status = queueList.getSelectedValue()
						.substring(queueList.getSelectedValue().lastIndexOf("(") + 1);
				if (queueList.getSelectedValues().length <= 0) {
					JOptionPane.showMessageDialog(null, "Choose one to unpause!");
				} else if (status.equals("paused)") == false) {
					JOptionPane.showMessageDialog(null, "You are not paused!");
				} else {
					sessionP = new JFrame();
					panels = new JPanel();
					session_pass.setBounds(100, 150, 300, 50);
					panels.add(session_pass);
					sessionP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					submitP = new JButton();
					submitP.setText("submit");
				}
				submitP.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						String name = queueList.getSelectedValue();
						String newName = name.substring(0, name.indexOf("("));
						arr.set(queueList.getSelectedIndex(), newName);
						Object[] objArr = arr.toArray();
						String[] str = Arrays.copyOf(objArr, objArr.length, String[].class);
						queueList.setListData(str);

					}
				});
				panels.setLayout(null);
				submitP.setBounds(200, 200, 80, 50);
				panels.add(submitP);
				sessionP.add(panels);
				sessionP.setSize(500, 500);
				sessionP.setVisible(true);

			}
		});
