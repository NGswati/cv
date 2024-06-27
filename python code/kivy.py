import kivymd
from kivy.app import App
from kivy.uix.label import Label
from kivy.uix.gridlayout import GridLayout
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
from kivy.uix.screenmanager import ScreenManager, Screen


class ConnectPage(GridLayout):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.cols = 2

        self.add_widget(Label(text="IP: "))
        self.ip = TextInput(multiline=False)
        self.add_widget(self.ip)

        self.add_widget(Label(text="Port: "))
        self.port = TextInput(multiline=False)
        self.add_widget(self.port)

        self.add_widget(Label(text="Username: "))
        self.un = TextInput(multiline=False)
        self.add_widget(self.un)

        self.join = Button(text="Join")
        self.join.bind(on_press=self.press)
        self.l1 = Label()
        self.add_widget(self.l1)
        self.add_widget(self.join)

    def press(self, instance):
        #        ip = self.ip.text
        #        port = self.port.text
        #        un = self.un.text
        #        self.l1.text = f"Attempting to join {ip} and {port} as {un}"
        test_app.scman.current = "Info"


class InfoPage(GridLayout):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)

        self.cols = 2

        self.about = Button(text="About")
        self.about.bind(on_press=self.ABouT)
        self.add_widget(self.about)

        self.abl = Label()
        self.add_widget(self.abl)

    def ABouT(self, instance):
        self.abl.text = "This app was made by a beginner"


class EpicApp(App):
    def build(self):
        self.scman = ScreenManager()

        self.page1 = ConnectPage()
        screen = Screen(name="Connect")
        screen.add_widget(self.page1)
        self.scman.add_widget(screen)

        self.page2 = InfoPage()
        screen = Screen(name="Info")
        screen.add_widget(self.page2)
        self.scman.add_widget(screen)
        return self.scman


test_app = EpicApp()
test_app.run()
