using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MineSweeper
{
    public partial class Form1 : Form
    {
        bool[,] mine = new bool[8, 10];
        bool[,] flag = new bool[8, 10];
        bool[,] checkedButton = new bool[8, 10];
        int[,] num = new int[8, 10];
        int[] dy = { -1, 0, 1, 0, -1, -1, 1, 1 };
        int[] dx = { 0, 1, 0, -1, -1, 1, 1, -1 };

        public Form1()
        {
            InitializeComponent();
            AttachClickEventHandlers();
            Random rand = new Random();
            int count = 0;
            while (count < 10)
            {
                int row = rand.Next(0, 8);
                int col = rand.Next(0, 10);

                if (!mine[row, col])
                {
                    mine[row, col] = true;
                    count++;
                }
            }

            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    int check = 0;
                    if (!mine[i, j])
                    {
                        for (int k = 0; k < 8; k++)
                        {
                            if (i + dy[k] >= 0 && i + dy[k] < 8 && j + dx[k] >= 0 && j + dx[k] < 10)
                            {
                                if (mine[i + dy[k], j + dx[k]])
                                {
                                    check++;
                                }
                            }
                        }
                        num[i, j] = check;
                    }
                    else { num[i, j] = -1; }
                }
            }
        }
        private void AttachClickEventHandlers()
        {
            foreach (Control control in tableLayoutPanel1.Controls)
            {
                if (control is Button button)
                {
                    button.Click += Button_Click;
                }
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void Button_Click(object sender, EventArgs e)
        {
            Button clickedButton = sender as Button;
            int buttonNumber = int.Parse(clickedButton.Name.Replace("button", ""));
            Minesweep(clickedButton);
        }
        private void Minesweep(Button clickedButton)
        {
            // 버튼의 행과 열을 찾습니다.
            int row = -1;
            int col = -1;

            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    if (tableLayoutPanel1.GetControlFromPosition(j, i) == clickedButton)
                    {
                        row = i;
                        col = j;
                        break;
                    }
                }
                if (row != -1) break;
            }

            if (row == -1 || col == -1) return; // 버튼을 찾지 못한 경우

            checkMine(row, col, clickedButton);
        }

        private void checkMine(int i, int j, Button clickedButton)
        {
            if (mine[i, j])
            {
                MessageBox.Show("펑!");
                for (int k = 0; k < 8; k++)
                {
                    for (int l = 0; l < 10; l++)
                    {
                        if (mine[k, l])
                        {
                            Button button = tableLayoutPanel1.GetControlFromPosition(l, k) as Button;
                            if (button != null)
                            {
                                button.BackColor = Color.Red;
                                button.Text = "☀";
                            }
                        }
                    }
                }
            }
            else
            {
                checkedButton[i, j] = true;
                if (num[i, j] != 0) { clickedButton.Text = $"{num[i, j]}"; }
                else { clickedButton.BackColor = Color.LightGreen; }

                if (num[i, j] == 0)
                {
                    for (int k = 0; k < 8; k++)
                    {
                        int ni = i + dy[k];
                        int nj = j + dx[k];
                        if (ni >= 0 && ni < 8 && nj >= 0 && nj < 10 && !checkedButton[ni, nj])
                        {
                            Button nextButton = tableLayoutPanel1.GetControlFromPosition(nj, ni) as Button;
                            if (nextButton != null)
                            {
                                Minesweep(nextButton);
                            }
                        }
                    }
                }
                int finish = 0;
                for (int k = 0; k < 8; k++) {
                    for (int h = 0; h < 10; h++)
                    {
                        if (checkedButton[k,h]) {
                            finish++;
                        }
                    }
                }
                if(finish == 70)
                {
                    MessageBox.Show("승리!");
                    for (int k = 0; k < 8; k++)
                    {
                        for (int l = 0; l < 10; l++)
                        {
                            if (mine[k, l])
                            {
                                Button button = tableLayoutPanel1.GetControlFromPosition(l, k) as Button;
                                if (button != null)
                                {
                                    button.Text = "☀";
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
      
