package controllers;

import core.Controller;
import views.RegisterGuestView;

/**
 * Controller for "Registrar invitado" tab. No persistence, just UI.
 */
public class RegisterGuestController extends Controller
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private RegisterGuestView view;

	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void run()
	{
		view = new RegisterGuestView(this);
	}

	public RegisterGuestView getView()
	{
		return view;
	}
}


