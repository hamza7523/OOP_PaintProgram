import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

public abstract class Button extends newRect implements Serializable
    {
        public boolean isHovering() {
            return hovering;
        }
        private String toolTipString;

        private Color textColor;


        private boolean state = false;
        private boolean disable;
        private boolean hovering;

        public void setHovering(boolean hovering) {
            this.hovering = hovering;
        }



        private String text;
        private Image image_depressed;
        private Image image_pressed;
        private Image current_image;
        private boolean pressed;
        private Reactor reactor;
        private Color color;
        protected Tooltip tooltip;


        public int getHeight() {
            return height;
        }
        public Image getImage_depressed(){
            return image_depressed;
        }

        public int getWidth() {
            return width;
        }
        public void setDisable(boolean disable){
            this.disable=disable;
        }
        public Button(int x,int y,int width,int height,Color color){
            super(x, y, width, height);
            this.color=color;

        }
        public void setText(String text){
            this.text =text;
        }

        public Button(int x, int y, String text, int width, int height, Image i_depressed, Image i_pressed)
        {

            super(x,y,width,height);
            tooltip = new Tooltip(new Point(x+10,y+10),width,height);
            image_depressed = i_depressed.getScaledInstance(width,height,Image.SCALE_FAST);
            image_pressed = i_pressed.getScaledInstance(width,height,Image.SCALE_FAST);
            current_image = image_depressed;
            this.text =text;




            reactor = new Reactor() {
                @Override
                public void click(int x, int y) {

                }

                @Override
                public void pressed(int x, int y) {

                }

                @Override
                public void released(int x, int y) {

                }

                @Override
                public void hover(int x, int y, Graphics g) {

                }



            };
        }

        public Image GetImage()
        {
            return current_image;
        }

        public void setImage(Image i){
            this.current_image =i;
        }

        public Boolean IsPressed()
        {
            return pressed;
        }
        public Boolean getPressed()
        {
            return pressed;
        }
        public Image getPressedImage(){
            return image_pressed;
        }

        public void setPressed(boolean pressed)
        {
            this.pressed = pressed;
        }

        public abstract boolean IsClicked(int x, int y);
        public abstract boolean ISinside(int x, int y);

        public void setToolTipString(String toolTipString) {
            this.toolTipString = toolTipString;
        }

        public Tooltip getTooltip() {
            return tooltip;
        }



        public void paint(Graphics g, ImageObserver observer){

            g.drawImage(this.GetImage(),x,y,observer);
            Font f = new Font("Ariel",1,10);
            g.setFont(f);
            FontMetrics m = g.getFontMetrics();
            int width = m.stringWidth(text);
            int height = m.getAscent() -m.getDescent();



            g.setColor(textColor);
            g.drawString(text,x+this.width/2-width/2,y+this.height/2+height/2);



        }
        public Reactor getReactor() {
            return reactor;
        }

        public void setTextColor(Color textColor) {
            this.textColor = textColor;
        }
        public void changeIcon(){

                if(this.IsPressed()==true){
                    this.setTextColor(Color.WHITE);
                    this.setImage(this.getPressedImage());
                    this.setTextColor(Color.black);
                }
                else{
                    this.setTextColor(Color.black);
                    this.setImage(this.getImage_depressed());

                }



        }

        public Color getTextColor() {
            return textColor;
        }
        public String getText(){
            return this.text;
        }

        public void setReactor(Reactor reactor) {
            this.reactor = reactor;
        }
        public void setState(boolean state){
            this.state = state;
        }

        public void ToggleRelease() {
            if (this.IsPressed() == true) {
                this.setPressed(false);
                this.setImage(this.getImage_depressed());
              //  this.changeIcon();
            }
        }



    }


