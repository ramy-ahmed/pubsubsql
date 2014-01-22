﻿namespace PubSubSQLGUI
{
    partial class SimulatorForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.groupBox = new System.Windows.Forms.GroupBox();
            this.line = new System.Windows.Forms.GroupBox();
            this.cancelButton = new System.Windows.Forms.Button();
            this.okButton = new System.Windows.Forms.Button();
            this.rowsUpDown = new System.Windows.Forms.NumericUpDown();
            this.columnsUpDown = new System.Windows.Forms.NumericUpDown();
            this.rowsLabel = new System.Windows.Forms.Label();
            this.columnsLabel = new System.Windows.Forms.Label();
            this.groupBox.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.rowsUpDown)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.columnsUpDown)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox
            // 
            this.groupBox.Controls.Add(this.line);
            this.groupBox.Controls.Add(this.cancelButton);
            this.groupBox.Controls.Add(this.okButton);
            this.groupBox.Controls.Add(this.rowsUpDown);
            this.groupBox.Controls.Add(this.columnsUpDown);
            this.groupBox.Controls.Add(this.rowsLabel);
            this.groupBox.Controls.Add(this.columnsLabel);
            this.groupBox.Location = new System.Drawing.Point(5, -1);
            this.groupBox.Name = "groupBox";
            this.groupBox.Size = new System.Drawing.Size(227, 150);
            this.groupBox.TabIndex = 27;
            this.groupBox.TabStop = false;
            // 
            // line
            // 
            this.line.Location = new System.Drawing.Point(12, 108);
            this.line.Name = "line";
            this.line.Size = new System.Drawing.Size(204, 3);
            this.line.TabIndex = 29;
            this.line.TabStop = false;
            // 
            // cancelButton
            // 
            this.cancelButton.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.cancelButton.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.cancelButton.Location = new System.Drawing.Point(57, 119);
            this.cancelButton.Name = "cancelButton";
            this.cancelButton.Size = new System.Drawing.Size(75, 23);
            this.cancelButton.TabIndex = 28;
            this.cancelButton.Text = "Cancel";
            // 
            // okButton
            // 
            this.okButton.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.okButton.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.okButton.Location = new System.Drawing.Point(141, 119);
            this.okButton.Name = "okButton";
            this.okButton.Size = new System.Drawing.Size(75, 23);
            this.okButton.TabIndex = 27;
            this.okButton.Text = "OK";
            this.okButton.Click += new System.EventHandler(this.okButton_Click_1);
            // 
            // rowsUpDown
            // 
            this.rowsUpDown.Location = new System.Drawing.Point(122, 47);
            this.rowsUpDown.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
            this.rowsUpDown.Minimum = new decimal(new int[] {
            10,
            0,
            0,
            0});
            this.rowsUpDown.Name = "rowsUpDown";
            this.rowsUpDown.Size = new System.Drawing.Size(94, 20);
            this.rowsUpDown.TabIndex = 7;
            this.rowsUpDown.Value = new decimal(new int[] {
            50,
            0,
            0,
            0});
            // 
            // columnsUpDown
            // 
            this.columnsUpDown.Location = new System.Drawing.Point(122, 19);
            this.columnsUpDown.Maximum = new decimal(new int[] {
            25,
            0,
            0,
            0});
            this.columnsUpDown.Minimum = new decimal(new int[] {
            2,
            0,
            0,
            0});
            this.columnsUpDown.Name = "columnsUpDown";
            this.columnsUpDown.Size = new System.Drawing.Size(94, 20);
            this.columnsUpDown.TabIndex = 6;
            this.columnsUpDown.Value = new decimal(new int[] {
            5,
            0,
            0,
            0});
            // 
            // rowsLabel
            // 
            this.rowsLabel.AutoSize = true;
            this.rowsLabel.Location = new System.Drawing.Point(12, 47);
            this.rowsLabel.Name = "rowsLabel";
            this.rowsLabel.Size = new System.Drawing.Size(37, 13);
            this.rowsLabel.TabIndex = 5;
            this.rowsLabel.Text = "Rows:";
            // 
            // columnsLabel
            // 
            this.columnsLabel.AutoSize = true;
            this.columnsLabel.Location = new System.Drawing.Point(12, 19);
            this.columnsLabel.Name = "columnsLabel";
            this.columnsLabel.Size = new System.Drawing.Size(50, 13);
            this.columnsLabel.TabIndex = 4;
            this.columnsLabel.Text = "Columns:";
            // 
            // SimulatorForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(237, 154);
            this.ControlBox = false;
            this.Controls.Add(this.groupBox);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Name = "SimulatorForm";
            this.Text = "Simulator";
            this.Load += new System.EventHandler(this.SimulatorForm_Load);
            this.groupBox.ResumeLayout(false);
            this.groupBox.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.rowsUpDown)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.columnsUpDown)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox;
        private System.Windows.Forms.GroupBox line;
        private System.Windows.Forms.Button cancelButton;
        private System.Windows.Forms.Button okButton;
        private System.Windows.Forms.NumericUpDown rowsUpDown;
        private System.Windows.Forms.NumericUpDown columnsUpDown;
        private System.Windows.Forms.Label rowsLabel;
        private System.Windows.Forms.Label columnsLabel;

    }
}