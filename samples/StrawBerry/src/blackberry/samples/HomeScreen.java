/**
 * Copyright (c) E.Y. Baskoro, Research In Motion Limited.
 * 
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 * 
 * This License shall be included in all copies or substantial 
 * portions of the Software.
 * 
 * The name(s) of the above copyright holders shall not be used 
 * in advertising or otherwise to promote the sale, use or other 
 * dealings in this Software without prior written authorization.
 * 
 */
package blackberry.samples;

import facebook.FacebookContext;
import facebook.FacebookException;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import blackberry.ui.AbstractScreen;

/**
 * HomeScreen
 * 
 * @author Eki Baskoro
 * @version 0.1
 * 
 */
final class HomeScreen extends AbstractScreen {

	// List of labels:
	private static final String LABEL_TITLE = "StrawBerry";
	private static final String LABEL_UPDATE_STATUS = "Update Status";
	private static final String LABEL_RECENT_UPDATES = "Recent Updates";
	private static final String LABEL_UPLOAD_PHOTO = "Upload Photos";
	private static final String LABEL_FRIENDS_LIST = "Friends List";
	private static final String LABEL_POKE_FRIEND = "Poke a Friend";
	private static final String LABEL_WRITE_WALL = "Write on a Wall";
	private static final String LABEL_SEND_MESSAGE = "Send a Message";

	private ButtonField updateStatusButton;
	private ButtonField recentUpdatesButton;
	private ButtonField uploadPhotoButton;
	private ButtonField friendListButton;
	private ButtonField pokeButton;
	private ButtonField wallButton;
	private ButtonField sendMessageButton;

	/**
	 * Default constructor.
	 * 
	 */
	HomeScreen() {
		LabelField titleLabel = new LabelField(LABEL_TITLE, LabelField.ELLIPSIS | LabelField.USE_ALL_WIDTH);
		setTitle(titleLabel);

		VerticalFieldManager topManager = new VerticalFieldManager(Manager.VERTICAL_SCROLL);
		add(topManager);

		updateStatusButton = new ButtonField(LABEL_UPDATE_STATUS) {
			protected boolean invokeAction(int action) {
				fireActioned(UpdateStatusScreen.ACTION_ENTER);
				return true;
			}
		};
		topManager.add(updateStatusButton);

		recentUpdatesButton = new ButtonField(LABEL_RECENT_UPDATES) {
			protected boolean invokeAction(int action) {
				fireActioned(RecentUpdatesScreen.ACTION_ENTER);
				return true;
			}
		};
		topManager.add(recentUpdatesButton);

		uploadPhotoButton = new ButtonField(LABEL_UPLOAD_PHOTO) {
			protected boolean invokeAction(int action) {
				fireActioned(UploadPhotoScreen.ACTION_ENTER);
				return true;
			}
		};
		topManager.add(uploadPhotoButton);

		friendListButton = new ButtonField(LABEL_FRIENDS_LIST) {
			protected boolean invokeAction(int action) {
				fireActioned(FriendsListScreen.ACTION_ENTER);
				return true;
			}
		};
		topManager.add(friendListButton);

		pokeButton = new ButtonField(LABEL_POKE_FRIEND) {
			protected boolean invokeAction(int action) {
				fireActioned(PokeFriendScreen.ACTION_ENTER);
				return true;
			}
		};
		topManager.add(pokeButton);

		wallButton = new ButtonField(LABEL_WRITE_WALL) {
			protected boolean invokeAction(int action) {
				fireActioned(PostWallScreen.ACTION_ENTER);
				return true;
			}
		};
		topManager.add(wallButton);

		sendMessageButton = new ButtonField(LABEL_SEND_MESSAGE) {
			protected boolean invokeAction(int action) {
				fireActioned(SendMessageScreen.ACTION_ENTER);
				return true;
			}
		};
		topManager.add(sendMessageButton);

		add(new SeparatorField());
	}

	public boolean onClose() {
		if (Dialog.ask("Please choose:", new String[] { "Exit", "Logout & Exit" }, 0) == 0) {
			System.exit(0);
		} else {
			try {
				FacebookContext.getInstance().clearSession();
			} catch (FacebookException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
		return true;
	}
}